package com.mfratila.movies.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationDTO {

    private String username;
    private String password;


}
