package com.newspaper.service;

import com.newspaper.entity.New;

import java.util.List;

public interface NewService {

    public List<New> getAllNew();

    public New getNewById(Long id);
}
