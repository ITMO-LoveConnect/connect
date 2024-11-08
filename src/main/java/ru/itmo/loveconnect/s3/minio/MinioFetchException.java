package ru.itmo.loveconnect.s3.minio;

public class MinioFetchException extends RuntimeException{
    public MinioFetchException(String message, Throwable cause) {
        super(message, cause);
    }
}