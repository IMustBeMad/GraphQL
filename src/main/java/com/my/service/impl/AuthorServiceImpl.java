package com.my.service.impl;

import com.my.entity.Author;
import com.my.repository.AuthorRepository;
import com.my.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Long getCount() {
        return authorRepository.count();
    }

    @Override
    @Transactional
    public Author addAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public void saveAll(List<Author> authors) {
        authorRepository.saveAll(authors);
    }
}
