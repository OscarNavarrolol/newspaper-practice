package com.newspaper.service.impl;

import com.newspaper.entity.New;
import com.newspaper.repository.NewRepository;
import com.newspaper.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewRepository newRepository;

    @Override
    public List<New> getAllNew() {
        return newRepository.findAll();
    }

    @Override
    public New getNewById(Long id) {
        return newRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        newRepository.deleteById(id);
    }


}
