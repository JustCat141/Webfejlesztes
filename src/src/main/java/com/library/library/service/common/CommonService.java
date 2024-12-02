package com.library.library.service.common;

import com.library.library.model.Member;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;

public interface CommonService<T> {
    List<T> findAll();

    T findById(int id);

    public T update(T obj);

    public void delete(T obj);
}
