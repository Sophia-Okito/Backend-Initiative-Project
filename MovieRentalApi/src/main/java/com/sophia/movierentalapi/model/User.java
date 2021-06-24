package com.sophia.movierentalapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Pattern(regexp = "USER|ADNIN" , flags = Pattern.Flag.CASE_INSENSITIVE, message = "Not a valid role")
    private String role;

}
