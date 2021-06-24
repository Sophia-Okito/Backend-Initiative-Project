package com.sophia.movierentalapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;
    @NotNull
    private String title;
    private int copies = 0;
}
