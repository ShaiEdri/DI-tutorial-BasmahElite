package com.blackops.songsappbasmahelite.producer;

import com.blackops.songsappbasmahelite.song.Song;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "producer", cascade = CascadeType.ALL)
    private List<Song> songs = new ArrayList<>();
}
