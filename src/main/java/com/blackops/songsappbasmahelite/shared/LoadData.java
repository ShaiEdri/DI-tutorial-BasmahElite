package com.blackops.songsappbasmahelite.shared;

import com.blackops.songsappbasmahelite.singer.Singer;
import com.blackops.songsappbasmahelite.singer.SingerRepository;
import com.blackops.songsappbasmahelite.song.Song;
import com.blackops.songsappbasmahelite.song.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class LoadData implements CommandLineRunner {
    private final SingerRepository singerRepository;
    private final SongRepository songRepository;

    public LoadData(SingerRepository singerRepository, SongRepository songRepository) {
        this.singerRepository = singerRepository;
        this.songRepository = songRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    @Transactional
    private void loadData() {
        Singer singer1 = new Singer();
        singer1.setFirstName("bob");
        singer1.setLastName("Marley");

        Song song1 = new Song();
        song1.setName("Big brown eyes");
        song1.setLength(2.3);

        song1.getSingers().add(singer1);
        singer1.getSongs().add(song1);

        singerRepository.save(singer1);
        songRepository.save(song1);

        List<Song> songsGreaterThan2 = songRepository.findByLengthGreaterThan(2D);
        songsGreaterThan2.stream().forEach(song -> System.out.println(song.getLength()));
    }
}
