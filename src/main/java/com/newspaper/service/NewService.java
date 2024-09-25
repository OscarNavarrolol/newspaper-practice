package com.newspaper.service;

import com.newspaper.dto.NewDto;
import com.newspaper.entity.New;
import com.newspaper.entity.User;

import java.util.List;

public interface NewService {

    public List<New> getAll();

    public New saveNew(New news);

    public New getNewById(Long id);

    public New updateNew(Long id, New news);

    public void deleteNew(long id);

    public List<Object[]> getNewByCategory(Long categoryId);

    public List<New> getMostRecentNews();
}
