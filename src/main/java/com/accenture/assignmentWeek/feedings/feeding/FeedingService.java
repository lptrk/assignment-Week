package com.accenture.assignmentWeek.feedings.feeding;

import com.accenture.assignmentWeek.feedings.feedingSchedule.FeedingScheduleEntity;
import com.accenture.assignmentWeek.feedings.feedingSchedule.FeedingScheduleRepository;
import com.accenture.assignmentWeek.horse.HorseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FeedingService {
    private final FeedingScheduleRepository feedingScheduleRepository;
    private final FeedingRepository feedingRepository;

    public FeedingService(FeedingScheduleRepository feedingScheduleRepository, FeedingRepository feedingRepository) {
        this.feedingScheduleRepository = feedingScheduleRepository;
        this.feedingRepository = feedingRepository;
    }

    public List<FeedingEntity> getAllFeedings() {
        return feedingRepository.findAll();
    }

    public FeedingEntity getFeedingById(Long id) {
        return feedingRepository.findById(id).orElseThrow();
    }

    public FeedingEntity updateFeedingById(Long id, FeedingEntity feedingEntity) {
        FeedingEntity feedingEntityToUpdate = feedingRepository.findById(id).orElseThrow();
        feedingEntityToUpdate.setFeedingTime(feedingEntity.getFeedingTime());
        feedingEntityToUpdate.setQuantityInGrams(feedingEntity.getQuantityInGrams());
        feedingEntityToUpdate.setHorse(feedingEntity.getHorse());
        feedingEntityToUpdate.setFoodType(feedingEntity.getFoodType());
        feedingEntityToUpdate.setFeedingPreferences(feedingEntity.getFeedingPreferences());
        feedingEntityToUpdate.setFeedingSchedule(feedingEntity.getFeedingSchedule());
        return feedingRepository.save(feedingEntityToUpdate);
    }
    public FeedingEntity saveFeeding(FeedingEntity feedingEntity) {
        return feedingRepository.save(feedingEntity);
    }

    public void deleteFeedingById(Long id) {
        feedingRepository.deleteById(id);
    }

    public List<HorseEntity> getEligibleHorses() {
        LocalTime currentTime = LocalTime.now();
        List<FeedingScheduleEntity> allSchedules = feedingScheduleRepository.findAll();
        List<HorseEntity> eligibleHorses = new ArrayList<>();

        for (FeedingScheduleEntity schedule : allSchedules) {
            if (schedule.getFeedingTime().equals(currentTime)) {
                HorseEntity horse = schedule.getHorse();
                if (horse != null) {
                    eligibleHorses.add(horse);
                }
            }
        }

        return eligibleHorses.isEmpty() ? Collections.emptyList() : eligibleHorses;
    }

    //TODO: implement feeding logic
    //TODO: get feeding schedule of horse
    //TODO: implement missed feeding logic





}
