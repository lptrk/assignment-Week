package com.accenture.assignmentWeek.stable;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StableService {
    public StableService(StableRepository stableRepository) {
        this.stableRepository = stableRepository;
    }

    private final StableRepository stableRepository;


    public List<StableEntity> getAllStables(){
        return stableRepository.findAll();
    }

    public StableEntity getStableById(Long id) {
        return stableRepository.findById(id)
                .orElseThrow();
    }

    public StableEntity updateStableById(Long id, StableEntity stable) {
        StableEntity stableToUpdate = stableRepository.findById(id).orElseThrow();
        stableToUpdate.setHorses(stable.getHorses());
        return stableToUpdate;
    }

    public void deleteStableById(Long id) {
        stableRepository.deleteById(id);
    }
}
