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

    public Page<New> getNewByCategory(Long categoryId,int offset, int limit);

    public Page<New> getMostRecentNews(int pageNumber, int pageSize);

    public Optional<List<New>> getByTitle(String title);

    public Page<New> findAllByUser(Long userId, int offset, int limit);
}
