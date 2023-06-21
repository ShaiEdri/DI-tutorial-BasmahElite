package com.blackops.songsappbasmahelite.singer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingerRepository extends JpaRepository<Singer, Long> {
    List<Singer>findByLastName(String lastName);
}
