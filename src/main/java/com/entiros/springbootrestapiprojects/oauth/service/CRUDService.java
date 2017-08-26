package com.entiros.springbootrestapiprojects.oauth.service;

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();

    T getById(String id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}