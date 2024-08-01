package org.routines.routines_be.controller;

import org.routines.routines_be.dto.RoutineRequestDTO;
import org.routines.routines_be.dto.UserIdDTO;
import org.routines.routines_be.entity.Routine;
import org.routines.routines_be.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/routine")
public class RoutineController {
    @Autowired
    private RoutineService routineService;

    @GetMapping
    public String getAny() {
        return "Hello World";
    }

    @GetMapping("/all")
    public List<Routine> getAll(@RequestBody UserIdDTO userId) {
        return routineService.getAllRoutines(userId.getUserId());
    }

    @PostMapping
    public void post(@RequestBody RoutineRequestDTO routineRequest) {
        routineService.saveRoutine(routineRequest);
    }
    @PutMapping
    public void put(@RequestBody RoutineRequestDTO routineRequest) {
        routineService.updateRoutine(routineRequest);
    }
    @DeleteMapping
    public void delete(@RequestBody RoutineRequestDTO routineRequest) {
        routineService.deleteRoutine(routineRequest);
    }
}
