package com.raphaelvizoni.replayme.service;

import com.raphaelvizoni.replayme.entity.StoragePort;
import com.raphaelvizoni.replayme.entity.dto.UploadFileResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class ReplayService {

    private final StoragePort storage;

    public ReplayService(StoragePort storage) {
        this.storage = storage;
    }

    public UploadFileResponse uploadFile(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID() + ".mp4";
            String uploadedFileURL = storage.uploadFile(
                    file.getInputStream(),
                    file.getSize(),
                    fileName,
                    file.getContentType()
            );
            return new UploadFileResponse(uploadedFileURL);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Erro ao ler arquivo para upload",
                    e
            );
        }
    }

}
