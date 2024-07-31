package org.routines.routines_be.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private String message;
}
