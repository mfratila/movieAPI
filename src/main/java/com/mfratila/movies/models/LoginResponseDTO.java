package com.mfratila.movies.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponseDTO {

    private ApplicationUser user;
    private String jwt;
}
