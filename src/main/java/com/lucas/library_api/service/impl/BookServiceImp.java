package com.lucas.library_api.service.impl;

import com.lucas.library_api.model.entity.Book;
import com.lucas.library_api.model.repository.BookRepository;
import com.lucas.library_api.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements BookService {

    private BookRepository repository;

    public BookServiceImp(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
