package com.accenture.assignmentWeek.feedings.feeding;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingService {
    private final FeedingRepository feedingRepository;

    public FeedingService(FeedingRepository feedingRepository) {
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
}
