package com.blackops.songsappbasmahelite.singer;

import com.blackops.songsappbasmahelite.producer.Producer;

import java.util.List;
import java.util.Optional;

public interface SingerService {
    Singer save(Singer singer);
    List<Singer> saveAll(List<Singer> singers);
    Optional<Singer> findById(Long id);
    void deleteById(Long id);
    List<Singer>findByLastName(String lastName);
    List<Singer>getSingers();
}
