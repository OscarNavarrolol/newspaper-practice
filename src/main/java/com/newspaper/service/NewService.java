package com.newspaper.service;


import com.newspaper.entity.New;
import com.newspaper.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface NewService {

    public List<New> getAll();

    public New saveNew(New news);

    public New getNewById(Long id);

    public New updateNew(Long id, New news);

    public void deleteNew(long id);

    public List<New> getNewByCategory(Long categoryId);

    public Page<New> getMostRecentNews(int pageNumber, int pageSize);

    public Optional<List<New>> getByTitle(String title);

    public Optional<List<New>> findAllByUser(Long userId);
}
