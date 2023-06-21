package com.blackops.songsappbasmahelite.singer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor//Constructor injection will happen
@Service
public class SingerServiceImpl implements SingerService {
    private final SingerRepository singerRepository;

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public List<Singer> saveAll(List<Singer> singers) {
        return singerRepository.saveAll(singers);
    }

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        singerRepository.deleteById(id);
    }

    @Override
    public List<Singer> findByLastName(String lastName) {
        return singerRepository.findByLastName(lastName);
    }

    @Override
    public List<Singer> getSingers() {
        return singerRepository.findAll();
    }
}
