package com.my.service;

import com.my.entity.Author;

import java.util.List;

public interface AuthorService {

    void saveAll(List<Author> authors);
}
