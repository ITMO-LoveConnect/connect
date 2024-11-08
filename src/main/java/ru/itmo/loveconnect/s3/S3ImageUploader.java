package ru.itmo.loveconnect.s3;

import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface S3ImageUploader {

    boolean uploadImage(@NonNull UUID photoId, @NonNull byte[] image);

}
