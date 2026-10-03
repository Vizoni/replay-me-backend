package com.raphaelvizoni.replayme.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "replay")
public class Replay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String s3Key;

    private Instant createdAt;

    public Replay() {
    }

    public Replay(
            String fileName,
            String s3Key
    ) {
        this.fileName = fileName;
        this.s3Key = s3Key;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getS3Key() {
        return s3Key;
    }

    public void setS3Key(String s3Key) {
        this.s3Key = s3Key;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}