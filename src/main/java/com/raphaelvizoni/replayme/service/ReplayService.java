package com.raphaelvizoni.replayme.service;

import com.raphaelvizoni.replayme.entity.Replay;
import com.raphaelvizoni.replayme.entity.StoragePort;
import com.raphaelvizoni.replayme.entity.dto.UploadFileResponse;
import com.raphaelvizoni.replayme.repository.ReplayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

@Service
public class ReplayService {

    private final StoragePort storage;

    private final ReplayRepository replayRepository;

    public ReplayService(StoragePort storage, ReplayRepository replayRepository) {
        this.storage = storage;
        this.replayRepository = replayRepository;
    }

    public UploadFileResponse createReplay(MultipartFile file) {
        try {
            String id = UUID.randomUUID().toString();
            String fileName = id + ".mp4";
            Instant timestamp = Instant.now();

            String uploadedFileURL = storage.uploadFile(
                    file.getInputStream(),
                    file.getSize(),
                    fileName,
                    file.getContentType()
            );

            UploadFileResponse response =
                    new UploadFileResponse(
                            id,
                            fileName,
                            uploadedFileURL,
                            timestamp
                    );

            Replay replay = new Replay(
                    response.fileName(),
                    response.id()
            );

            replayRepository.save(replay);

            return response;
        } catch (IOException e) {
            throw new RuntimeException(
                    "Erro ao ler arquivo para upload",
                    e
            );
        }
    }

}
