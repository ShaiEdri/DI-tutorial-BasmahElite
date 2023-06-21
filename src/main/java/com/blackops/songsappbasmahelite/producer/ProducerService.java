package com.blackops.songsappbasmahelite.producer;

import java.util.List;
import java.util.Optional;

public interface ProducerService {
    Producer save(Producer producer);
    List<Producer> saveAll(List<Producer> producers);
    Optional<Producer> findById(Long id);
    void deleteById(Long id);
}








