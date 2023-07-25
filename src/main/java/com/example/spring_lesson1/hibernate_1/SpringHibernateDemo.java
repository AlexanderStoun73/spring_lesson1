package com.example.spring_lesson1.hibernate_1;

import com.example.spring_lesson1.hibernate.AppConfig;
import com.example.spring_lesson1.hibernate_1.entities.Album;
import com.example.spring_lesson1.hibernate_1.entities.Instrument;
import com.example.spring_lesson1.hibernate_1.entities.Singer;
import com.example.spring_lesson1.hibernate_1.repository.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class SpringHibernateDemo {
    private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        SingerDao singerDao = context.getBean(SingerDao.class);
        Singer singer = singerDao.findByid(2l);
        singerDao.delete(singer);
        listSingers(singerDao.findAll());

        context.close();
    }

    private static void listSingers(List<Singer> singers) {
        logger.info("---- Listening singers: ");
        for (Singer singer : singers) {
            logger.info(singer.toString());
        }
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info(" ---- Listing singers with instruments:");
        for (Singer singer : singers) {
            logger.info(singer.toString());
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    logger.info("\t" + album.toString());
                }
            }
            if (singer.getInstruments() != null) {
                for (Instrument instrument : singer.getInstruments()) {
                    logger.info("\t" + instrument.toString());
                }
            }
        }
    }
}
