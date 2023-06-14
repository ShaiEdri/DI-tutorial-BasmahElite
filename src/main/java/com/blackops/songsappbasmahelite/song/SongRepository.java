package com.blackops.songsappbasmahelite.song;

import com.blackops.songsappbasmahelite.singer.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByLengthGreaterThan(Double length);
}
