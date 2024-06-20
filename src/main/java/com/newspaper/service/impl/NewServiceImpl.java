package com.newspaper.service.impl;

import com.newspaper.dto.NewDto;
import com.newspaper.entity.New;
import com.newspaper.repository.NewRepository;
import com.newspaper.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewRepository newRepository;

    @Override
    public List<NewDto> getAllNew() {
        return newRepository.findAll().stream()
                .map(newObj -> new NewDto(newObj.getTitle(), newObj.getContent(), newObj.getPublicationDate()))
                .collect(Collectors.toList());
    }

    @Override
    public NewDto getNewById(Long id) {
        return newRepository.findById(id)
                .map(newObj -> new NewDto(newObj.getTitle(), newObj.getContent(), newObj.getPublicationDate()))
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        newRepository.deleteById(id);
    }


}
