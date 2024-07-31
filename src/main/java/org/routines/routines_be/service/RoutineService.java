package org.routines.routines_be.service;

import org.routines.routines_be.entity.Routine;
import org.routines.routines_be.repository.RoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutineService {
    @Autowired
    private RoutineRepository routineRepository;

    public List<Routine> getAllRoutines(String userId) {
        return routineRepository.findByUserIdRoutine(userId);
    }
}
