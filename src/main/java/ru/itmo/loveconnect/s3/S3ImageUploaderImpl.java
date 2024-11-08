package ru.itmo.loveconnect.s3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import ru.itmo.loveconnect.s3.minio.MinioException;
import ru.itmo.loveconnect.s3.minio.MinioService;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3ImageUploaderImpl implements S3ImageUploader {

    private final MinioService minioService;

    @Override
    public boolean uploadImage(@NonNull UUID photoId, @NonNull byte[] image) {
        try {
            minioService.upload(Path.of(photoId + ".jpg"), new ByteArrayInputStream(image));
            return true;
        } catch (MinioException e) {
            log.error("Cannot upload image " + photoId, e);
        }
        return false;
    }

}
