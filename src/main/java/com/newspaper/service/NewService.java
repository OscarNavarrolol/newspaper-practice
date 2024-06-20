package com.newspaper.service;

import com.newspaper.dto.NewDto;
import com.newspaper.entity.New;

import java.util.List;

public interface NewService {

    public List<NewDto> getAllNew();

    public NewDto getNewById(Long id);

    public void deleteById(Long id);


    public NewDto getNewMostRecent();
}
