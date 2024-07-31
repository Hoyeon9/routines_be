package org.routines.routines_be.controller;

import org.routines.routines_be.dto.UserIdDTO;
import org.routines.routines_be.entity.Routine;
import org.routines.routines_be.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Routine> getAll(@RequestBody UserIdDTO userIdDTO) {
        System.out.println(userIdDTO.getUserId());
        return routineService.getAllRoutines(userIdDTO.getUserId());
    }
}
