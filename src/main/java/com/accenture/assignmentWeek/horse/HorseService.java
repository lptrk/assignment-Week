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
        return horseRepository.findById(id).orElseThrow();
    }

    public HorseEntity saveHorse(HorseEntity horse) {
        return horseRepository.save(horse);
    }

    public HorseEntity updateHorseById(String id, HorseEntity horse) {
        HorseEntity entityToUpdate = horse;

        entityToUpdate.setBreed(horse.getBreed());
        entityToUpdate.setName(horse.getName());
        entityToUpdate.setFeedingSchedules(horse.getFeedingSchedules());
        entityToUpdate.setOwner(horse.getOwner());
        entityToUpdate.setNickName(horse.getNickName());
        entityToUpdate.setNumberOfDailyFeedings(horse.getNumberOfDailyFeedings());
        entityToUpdate.setStable(horse.getStable());

        return entityToUpdate;
    }

    public void deleteHorseById(String id){
        horseRepository.deleteById(id);
    }
}
