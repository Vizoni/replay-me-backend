package com.raphaelvizoni.replayme.entity.dto;

import java.time.Instant;

public record UploadFileResponse(String id, String fileName, String url, Instant createdAt) {

}
