package com.newspaper.service.impl;

import com.newspaper.entity.Category;
import com.newspaper.entity.New;
import com.newspaper.entity.User;
import com.newspaper.repository.CategoryRepository;
import com.newspaper.repository.NewRepository;
import com.newspaper.repository.UserRepository;
import com.newspaper.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewRepository newRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<New> getAll() {
        return newRepository.findAll();
    }

    @Override
    public New saveNew(New news) {
        Optional<User> userOptional = userRepository.findById(news.getUser().getId());
        Optional<Category> categoryOptional = categoryRepository.findById(news.getCategory().getId());

        if (userOptional.isPresent() && categoryOptional.isPresent()) {
            news.setUser(userOptional.get());
            news.setCategory(categoryOptional.get());
            return newRepository.save(news);
        } else {

            throw new IllegalArgumentException("User or Category does not exist");
        }

    }

    @Override
    public New getNewById(Long id) {
        return newRepository.findById(id).orElse(null);
    }

    @Override
    public New updateNew(Long id, New news) {
        New oldNew = newRepository.findById(id).orElse(null);


        if (oldNew != null){
            oldNew.setTitle(news.getTitle());
            oldNew.setContent(news.getContent());
            oldNew.setPublicationDate(news.getPublicationDate());

            Optional<User> userOptional = userRepository.findById(news.getUser().getId());
            Optional<Category> categoryOptional = categoryRepository.findById(news.getCategory().getId());

            if (userOptional.isPresent() && categoryOptional.isPresent()) {
                oldNew.setUser(userOptional.get());
                oldNew.setCategory(categoryOptional.get());
                return newRepository.save(oldNew);
            } else {
                throw new IllegalArgumentException("User or Category does not exist");
            }

        }
        return null;
    }

    @Override
    public void deleteNew(long id) {
        newRepository.deleteById(id);

    }

    @Override
    public List<Object[]> getNewByCategory(Long categoryId) {
        return newRepository.getNewsByCategory(categoryId);
    }

    @Override
    public Page<New> getMostRecentNews(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return newRepository.findRecentNew(pageable);
    }

    @Override
    public Optional<List<New>> getByTitle(String title) {
        return newRepository.findByTitle(title);
    }
}
