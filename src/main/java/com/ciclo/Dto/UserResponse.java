package com.ciclo.Dto;
import lombok.Data;

@Data
public class UserResponse {
    private long idUser;
    private String username;
    private String email;
    private String imageurl;
    private String password;
    private String cryptmethod;
}
