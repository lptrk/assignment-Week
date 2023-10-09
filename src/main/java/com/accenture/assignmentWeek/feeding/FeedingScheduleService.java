package com.accenture.assignmentWeek.feeding;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingScheduleService {
    public FeedingScheduleService(FeedingScheduleRepository feedingScheduleRepository) {
        this.feedingScheduleRepository = feedingScheduleRepository;
    }

    private final FeedingScheduleRepository feedingScheduleRepository;

    public List<FeedingScheduleEntity> getAllFeedingSchedules() {
        return feedingScheduleRepository.findAll();
    }

    public FeedingScheduleEntity getFeedingScheduleById(Long id) {
        return feedingScheduleRepository.findById(id).orElseThrow();
    }

    public FeedingScheduleEntity updateFeedingScheduleById(Long id, FeedingScheduleEntity feedingScheduleEntity) {
        FeedingScheduleEntity entityToUpdate = feedingScheduleRepository.findById(id).orElseThrow();
        entityToUpdate.setFeedingTime(feedingScheduleEntity.getFeedingTime());
        entityToUpdate.setHorse(feedingScheduleEntity.getHorse());
        entityToUpdate.setNumberOfFeedings(feedingScheduleEntity.getNumberOfFeedings());

        return entityToUpdate;
    }

    public FeedingScheduleEntity saveFeedingSchedule(FeedingScheduleEntity feedingScheduleEntity) {
        return feedingScheduleRepository.save(feedingScheduleEntity);
    }

    public void deleteFeedingScheduleById(Long id) {
        feedingScheduleRepository.deleteById(id);
    }
}
