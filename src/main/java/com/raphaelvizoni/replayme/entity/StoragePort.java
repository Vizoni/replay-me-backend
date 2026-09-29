package com.raphaelvizoni.replayme.entity;

import java.io.InputStream;

public interface StoragePort {

        String uploadFile(
                InputStream inputStream,
                long contentLength,
                String fileName,
                String contentType
        );
}
