package com.raphaelvizoni.replayme.controller;

import com.raphaelvizoni.replayme.entity.dto.UploadFileResponse;
import com.raphaelvizoni.replayme.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/api/replays")
public class ReplayController {

    @Autowired
    private ReplayService replayService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UploadFileResponse> upload(
            @RequestParam("file") MultipartFile file
    ) {

        try {
            UploadFileResponse response = replayService.uploadFile(file);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
