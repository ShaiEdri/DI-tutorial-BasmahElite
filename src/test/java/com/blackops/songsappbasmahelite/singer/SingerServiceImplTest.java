package com.blackops.songsappbasmahelite.singer;

import com.blackops.songsappbasmahelite.SongsAppBasmahEliteApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest(classes = SongsAppBasmahEliteApplication.class)
class SingerServiceImplTest {
    @Autowired
    SingerRepository singerRepository;
    private SingerService singerService;
    private static Singer user1;
    private static Singer user2;
    private static final Long TEST_ID1 = 123L;
    private static final Long TEST_ID2 = 1234L;
    @BeforeAll
    static void startUp(){
        user1 = Singer.builder().id(TEST_ID1)
                .firstName("John").lastName("Doe").build();
        user2 = Singer.builder().id(TEST_ID2)
                .firstName("Jane").lastName("Smith").build();
    }
    @BeforeEach
    void setUp() {
        singerService = new SingerServiceImpl(singerRepository);
    }

    @Test
    void findByLastName() {
        singerService.saveAll(List.of(user1, user2));
        List<Singer>singersTotal = singerService.getSingers();
        List<Singer>singers = singerService.findByLastName("Doe");
        assertEquals(1, singers.size());
        assertEquals("Doe", singers.get(0).getLastName());
    }

    @Test
    void getSingers() {
        singerRepository.saveAll(List.of(user1, user2));
        List<Singer> singers = singerService.getSingers();
        assertTrue(singers.size() > 1);
    }


    @Test
    void deleteById() {
        singerService.saveAll(List.of(user1, user2));
        Singer johnDoe = singerService.findByLastName("Doe").get(0);
        List<Singer> singersBefore = singerService.getSingers();
        singerService.deleteById(johnDoe.getId());
        List<Singer> singersAfter = singerService.getSingers();
        assertTrue(singersAfter.size() == singersBefore.size() -1);
        Optional<Singer> shouldNotExist = singerService.findById(johnDoe.getId());
        assertNull(shouldNotExist.get());
    }
}