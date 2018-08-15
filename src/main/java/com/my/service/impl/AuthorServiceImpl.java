package com.my.service.impl;

import com.my.entity.Author;
import com.my.repository.AuthorRepository;
import com.my.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void saveAll(List<Author> authors) {
        authorRepository.saveAll(authors);
    }
}
