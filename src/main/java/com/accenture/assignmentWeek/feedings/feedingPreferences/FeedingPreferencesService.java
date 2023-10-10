package com.accenture.assignmentWeek.feedings.feedingPreferences;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingPreferencesService {
    private final FeedingPreferencesRepository feedingPreferencesRepository;

    public FeedingPreferencesService(FeedingPreferencesRepository feedingPreferencesRepository) {
        this.feedingPreferencesRepository = feedingPreferencesRepository;
    }

    public List<FeedingPreferencesEntity> getAlleedingPreferences() {
        return feedingPreferencesRepository.findAll();
    }

    public FeedingPreferencesEntity getFeedingPreferencesByID(Long id) {
        return feedingPreferencesRepository.findById(id).orElseThrow();
    }

    public FeedingPreferencesEntity updateFeedingPreferencesById(Long id, FeedingPreferencesEntity feedingPreferencesEntity) {
        FeedingPreferencesEntity entityToUpdate = feedingPreferencesRepository.findById(id).orElseThrow();

        entityToUpdate.setFoodType(feedingPreferencesEntity.getFoodType());
        entityToUpdate.setHorse(feedingPreferencesEntity.getHorse());
        entityToUpdate.setMinFeedingsPerDay(entityToUpdate.getMinFeedingsPerDay());
        entityToUpdate.setMaxFeedingsPerDay(entityToUpdate.getMaxFeedingsPerDay());
        entityToUpdate.setPreferredFeedingsPerDay(entityToUpdate.getPreferredFeedingsPerDay());

        return entityToUpdate;
    }

    public FeedingPreferencesEntity saveFeedingPreerences(FeedingPreferencesEntity feedingPreferencesEntity) {
        return feedingPreferencesRepository.save(feedingPreferencesEntity);
    }

    public void deleteFeedingPreferencesById(Long id) {
        feedingPreferencesRepository.deleteById(id);
    }
}
