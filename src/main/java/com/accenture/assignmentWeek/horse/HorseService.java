package com.accenture.assignmentWeek.horse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseService {
    private final HorseRepository horseRepository;

    public HorseService(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    public List<HorseEntity> getAllHorses() {
        return horseRepository.findAll();
    }

    public HorseEntity getHorseById(String id) {
        return horseRepository.findById(id).orElse(null);
    }

    public HorseEntity saveHorse(HorseEntity horse) {
        return horseRepository.save(horse);
    }

    public HorseEntity updateHorseById(String id, HorseEntity horse) {

        horse.setBreed(horse.getBreed());
        horse.setName(horse.getName());
        horse.setFeedingSchedules(horse.getFeedingSchedules());
        horse.setOwner(horse.getOwner());
        horse.setNickName(horse.getNickName());
        horse.setStable(horse.getStable());

        return horseRepository.save(horse);
    }

    public void deleteHorseById(String id) {
        horseRepository.deleteById(id);
    }
}
