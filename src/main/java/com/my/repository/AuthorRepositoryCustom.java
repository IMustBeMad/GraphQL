package com.my.repository;

import com.my.entity.Author;

import java.util.List;

public interface AuthorRepositoryCustom {

    List<Author> findAllPaginated(Integer pageIndex);
}
