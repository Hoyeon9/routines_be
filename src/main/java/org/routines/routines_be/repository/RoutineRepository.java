package org.routines.routines_be.repository;

import jakarta.transaction.Transactional;
import org.routines.routines_be.entity.Routine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoutineRepository extends CrudRepository<Routine, Long> {
    List<Routine> findByUserIdRoutine(String userIdRoutine);
    Routine findByRoutineId(long routineId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Routine r SET r.routineName = :routineName, r.routineDesc = :routineDesc WHERE r.routineId = :routineId")
    void updateByRoutineId(long routineId, String routineName, String routineDesc);
}
