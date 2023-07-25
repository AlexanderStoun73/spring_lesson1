package com.example.spring_lesson1.hibernate_1.repository.impl;

import com.example.spring_lesson1.hibernate_1.entities.Singer;
import com.example.spring_lesson1.hibernate_1.repository.SingerDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("singerDao")
public class SingerDaoimpl implements SingerDao {
    private SessionFactory sessionFactory;

    public SingerDaoimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true) // Аннотация @Transactional ( readOnly= true) означает,
                                   // что транзакция должна быть установлена ка доступная только для чтения
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return null;
    }

    @Override
    public Singer findByid(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer contact) {
        return null;
    }

    @Override
    public void delete(Singer contact) {

    }
}
