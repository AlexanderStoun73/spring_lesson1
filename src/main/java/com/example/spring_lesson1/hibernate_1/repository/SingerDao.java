package com.example.spring_lesson1.hibernate_1.repository;

import com.example.spring_lesson1.hibernate_1.entities.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findByid(Long id);
    Singer save(Singer contact);
    void delete(Singer contact);
}
