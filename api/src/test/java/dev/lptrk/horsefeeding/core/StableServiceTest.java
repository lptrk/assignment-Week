package dev.lptrk.horsefeeding.core;


import dev.lptrk.horsefeeding.dto.StableResponseDTO;
import dev.lptrk.horsefeeding.entity.Stable;
import dev.lptrk.horsefeeding.repository.StableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)//implements autoclosable
class StableServiceTest {

    @Mock
    private StableRepository stableRepository;
    private StableService underTest;

    @BeforeEach
    void setup() {
        underTest = new StableService(stableRepository);
    }

    @Test
    void canGetAllStables() {
        //when
        underTest.getAllStables();
        //then
        verify(stableRepository).findAll();

    }

    @Test
    void canGetStableById(){
        Integer testId=3;
        underTest.getStable(testId);
        verify(stableRepository).findById(testId);
    }

    @Test
    void canDeleteStableById() {
        Integer testId = 3;
        underTest.deleteStableById(testId);
        verify(stableRepository).deleteById(testId);
    }
}