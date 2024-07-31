package org.routines.routines_be.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "routines")
@NoArgsConstructor
@AllArgsConstructor
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routineId;
    private String userIdRoutine;
    private String routineName;
    private String routineDesc;
    private int serialCount;
    private int serialFailed;
}
