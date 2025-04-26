package com.example.library.controller;

import com.example.library.dto.ReadingDTO;
import com.example.library.model.Reading;
import com.example.library.service.ReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/readings")
public class ReadingController {

    private final ReadingService readingService;
    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping
    public List<ReadingDTO> getAllReadings() {
        return readingService.findAll().stream()
                .map(r -> new ReadingDTO(
                        r.getClient().getFullName(),
                        r.getClient().getBirthDate().toString(),
                        r.getBook().getTitle(),
                        r.getBook().getAuthor(),
                        r.getBook().getIsbn(),
                        r.getReadingDate().toString()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Reading takeBook(@RequestBody Map<String, Long> body) {
        Long clientId = body.get("clientId");
        Long bookId = body.get("bookId");
        return readingService.takeBook(clientId, bookId);
    }

}
