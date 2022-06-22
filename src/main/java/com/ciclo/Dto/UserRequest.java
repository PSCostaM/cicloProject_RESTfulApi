package com.ciclo.Dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    private String imageurl;
    @NotBlank
    private String password;
}
