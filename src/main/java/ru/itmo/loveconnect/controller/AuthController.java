package ru.itmo.loveconnect.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.auth.AuthService;
import ru.itmo.loveconnect.dto.IsRegisteredDto;
import ru.itmo.loveconnect.dto.LoginDto;
import ru.itmo.loveconnect.dto.RegisterDto;
import ru.itmo.loveconnect.dto.RequestPrefilledProfileDto;
import ru.itmo.loveconnect.dto.SendConfirmationDto;
import ru.itmo.loveconnect.dto.TokenDto;
import ru.itmo.loveconnect.isu.IsuService;
import ru.itmo.loveconnect.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IsuService isuService;
    private final AuthService authService;
    private final UserServiceImpl userService;

    @PostMapping("/sendConfirmationCode")
    public ResponseEntity<?> sendConfirmationCode(@RequestBody SendConfirmationDto body) {
        authService.sendConfirmationCode(body.getIsuNumber());
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/requestPrefilledProfile")
    public ResponseEntity<?> requestPrefilledProfile(@RequestBody RequestPrefilledProfileDto body) {
        if (authService.isOtpCodeValid(body.getIsuNumber(), body.getConfirmationCode())) {
            return ResponseEntity.ok(isuService.getIsuReport(body.getIsuNumber()));
        }
        return ResponseEntity.badRequest().body("Invalid OTP code");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDto body) {
        if (authService.isOtpCodeValid(body.getIsuNumber(), body.getConfirmationCode())) {
            String token = authService.registerUserIfOtpCodeValid(body.getIsuNumber(),
                    body.getConfirmationCode(),
                    body.getProfile());
            return ResponseEntity.ok(new TokenDto(token));
        }
        return ResponseEntity.badRequest().body("Invalid OTP code");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto body) {
        if (authService.isOtpCodeValid(body.getIsuNumber(), body.getConfirmationCode())) {
            String token = authService.loginUserIfOtpCodeValid(body.getIsuNumber(),
                    body.getConfirmationCode());
            return ResponseEntity.ok(new TokenDto(token));
        }
        return ResponseEntity.badRequest().body("Invalid OTP code");
    }

    @GetMapping("/isRegistered")
    public ResponseEntity<?> isRegistered(@RequestParam String isuNumber) {
        return ResponseEntity.ok(
                new IsRegisteredDto(userService.isRegisteredByIsuNumber(isuNumber)));
    }

}
