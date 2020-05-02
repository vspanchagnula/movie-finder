package com.movieapp.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.movieapp.data.entity.Screen;

import java.util.List;

public interface ScreenRepository extends CrudRepository<Screen, Long> {
    public Screen findByScreenId(long screenId);
    public List<Screen> findByTheatreId(long theatreId);
}
