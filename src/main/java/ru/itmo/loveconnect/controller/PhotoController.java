package ru.itmo.loveconnect.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.itmo.loveconnect.dto.UploadPhotoDto;
import ru.itmo.loveconnect.repo.UserRepository;
import ru.itmo.loveconnect.s3.S3ImageUploaderImpl;
import ru.itmo.loveconnect.s3.minio.MinioService;
import ru.itmo.loveconnect.security.auth.principal.AuthenticatedUser;
import ru.itmo.loveconnect.service.impl.UserServiceImpl;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequestMapping("/photo")
@RestController
@RequiredArgsConstructor
public class PhotoController {

    private final MinioService minioService;
    private final S3ImageUploaderImpl s3ImageUploaderImpl;

    @PostMapping(value = "/upload", consumes = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> uploadPhoto(@RequestBody byte[] input) {
        UUID photoId = UUID.randomUUID();
        s3ImageUploaderImpl.uploadImage(photoId, input);
        return ResponseEntity.ok(new UploadPhotoDto(photoId));
    }

    @SneakyThrows
    @GetMapping(value = "/{photoId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> getPhoto(@PathVariable("photoId") UUID photoId) {
        return ResponseEntity.ok(minioService
                .get(Path.of(photoId + ".jpg"))
                .readAllBytes());
    }

}
