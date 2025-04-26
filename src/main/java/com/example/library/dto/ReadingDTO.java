package com.example.library.dto;

import lombok.Data;

@Data
public class ReadingDTO {
    private final String clientName;
    private final String clientBirthDate;
    private final String bookTitle;
    private final String bookAuthor;
    private final String bookIsbn;
    private final String readingDate;
}