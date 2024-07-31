package org.routines.routines_be.dto;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String userId;
    private String password;
    private String username;
    private String email;
}
