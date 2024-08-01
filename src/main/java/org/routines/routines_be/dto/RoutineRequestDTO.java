package org.routines.routines_be.dto;

import lombok.Data;

@Data
public class RoutineRequestDTO {
    private String userId;
    private long routineId;
    private String routineName;
    private String routineDesc;
}
