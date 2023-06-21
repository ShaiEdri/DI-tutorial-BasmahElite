package com.blackops.songsappbasmahelite.singer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@DataJpaTest
class SingerRepositoryTest {
    @Autowired
    private SingerRepository singerRepository;

    private Singer testedSinger;
    private final String FIRST_NAME = "Israel";
    private final String LAST_NAME = "Israeli";

    @BeforeEach
    void setUp() {
        testedSinger = Singer.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .build();
    }

    @DirtiesContext
    @Test
    void findByLastNameTestExist() {
        singerRepository.save(testedSinger);
        List<Singer> singers = singerRepository.findByLastName(LAST_NAME);
        assertTrue(singers.size() == 1);
        assertEquals(singers.get(0).getLastName(), LAST_NAME);
    }

    @Test
    void findByLastNameTestNotExist() {
        singerRepository.save(testedSinger);
        List<Singer> singers = singerRepository.findByLastName("Edri");
        assertTrue(singers.size() == 0);
    }
}