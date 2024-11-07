package ru.itmo.loveconnect.s3.minio;

public class MinioException extends Exception {
    public MinioException(String message, Throwable cause) {
        super(message, cause);
    }
}