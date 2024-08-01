package org.routines.routines_be.service;

import jakarta.transaction.Transactional;
import org.routines.routines_be.dto.RoutineRequestDTO;
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
    public void saveRoutine(RoutineRequestDTO routineRequest) {
        Routine routine = new Routine();
        routine.setUserIdRoutine(routineRequest.getUserId());
        routine.setRoutineName(routineRequest.getRoutineName());
        routine.setRoutineDesc(routineRequest.getRoutineDesc());
        routineRepository.save(routine);
    }

    public void updateRoutine(RoutineRequestDTO routineRequest) {
        if(routineRequest.getUserId().equals(routineRepository.findByRoutineId(routineRequest.getRoutineId()).getUserIdRoutine())){
            routineRepository.updateByRoutineId(routineRequest.getRoutineId(), routineRequest.getRoutineName(), routineRequest.getRoutineDesc());
        }
    }
    @Transactional
    public void deleteRoutine(RoutineRequestDTO routineRequest) {
        if(routineRequest.getUserId().equals(routineRepository.findByRoutineId(routineRequest.getRoutineId()).getUserIdRoutine())){
            routineRepository.deleteByRoutineId(routineRequest.getRoutineId());
        }
    }

}
