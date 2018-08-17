package com.my.service;

import com.my.entity.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAll();

    Long getCount();

    Author addAuthor(String firstName, String lastName);

    void saveAll(List<Author> authors);

    List<Author> getAllPaginated(Integer pageIndex);
}
