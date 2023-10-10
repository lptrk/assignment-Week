package com.accenture.assignmentWeek.feedings.missedFeeding;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissedFeedingService {
    private final MissedFeedingRepository missedFeedingRepository;

    public MissedFeedingService(MissedFeedingRepository missedFeedingRepository) {
        this.missedFeedingRepository = missedFeedingRepository;
    }

    public MissedFeedingEntity saveMissedFeeding(MissedFeedingEntity missedFeedingEntity) {
        return missedFeedingRepository.save(missedFeedingEntity);
    }

    public List<MissedFeedingEntity> getAllMissedFeedings() {
        return missedFeedingRepository.findAll();
    }

    public MissedFeedingEntity getMissedFeedingById(Long id) {
        return missedFeedingRepository.findById(id).orElseThrow();
    }

    public MissedFeedingEntity updateMissedFeedingById(Long id, MissedFeedingEntity missedFeedingEntity) {
        MissedFeedingEntity missedFeedingEntityToUpdate = missedFeedingRepository.findById(id).orElseThrow();
        missedFeedingEntityToUpdate.setMissedFeedingTime(missedFeedingEntity.getMissedFeedingTime());

        return missedFeedingRepository.save(missedFeedingEntityToUpdate);
    }

    public void deleteMissedFeedingById(Long id) {
        missedFeedingRepository.deleteById(id);
    }
}
