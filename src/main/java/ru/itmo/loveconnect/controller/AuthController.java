package ru.itmo.loveconnect.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.loveconnect.isu.IsuService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IsuService isuService;

    @RequestMapping("/isu/{isuNumber}")
    public ResponseEntity<?> getIsuReport(@PathVariable String isuNumber) {
        return ResponseEntity.ok(isuService.getIsuReport(isuNumber));
    }

}
