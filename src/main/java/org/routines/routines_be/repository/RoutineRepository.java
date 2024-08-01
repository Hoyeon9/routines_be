package org.routines.routines_be.repository;

import org.routines.routines_be.entity.Routine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoutineRepository extends CrudRepository<Routine, Long> {
    List<Routine> findByUserIdRoutine(String userIdRoutine);
    Routine findByRoutineId(Long routineId);
}
