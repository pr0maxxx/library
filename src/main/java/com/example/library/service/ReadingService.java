package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Client;
import com.example.library.model.Reading;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ClientRepository;
import com.example.library.repository.ReadingRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReadingService {

    private final ReadingRepository readingRepository;
    private final ClientRepository clientRepository;
    private final BookRepository bookRepository;

    public ReadingService(ReadingRepository readingRepository, ClientRepository clientRepository, BookRepository bookRepository) {
        this.readingRepository = readingRepository;
        this.clientRepository = clientRepository;
        this.bookRepository = bookRepository;
    }

    public Reading takeBook(Long clientId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));

        Reading reading = new Reading();
        reading.setClient(client);
        reading.setBook(book);
        reading.setReadingDate(LocalDateTime.now());

        return readingRepository.save(reading);
    }

    public List<Reading> findAll() {
        return readingRepository.findAll();
    }
}
