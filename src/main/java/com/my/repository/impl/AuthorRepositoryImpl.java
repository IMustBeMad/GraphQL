package com.my.repository.impl;

import com.my.entity.Author;
import com.my.repository.AuthorRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private static final int PAGE_SIZE = 3;

    @Override
    public List<Author> findAllPaginated(Integer pageIndex) {
        return entityManager.createQuery("from Author", Author.class)
                            .setFirstResult(pageIndex * PAGE_SIZE)
                            .setMaxResults(PAGE_SIZE)
                            .getResultList();
    }
}
