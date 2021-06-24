package com.sophia.movierentalapi.payload;

import lombok.Data;

@Data
public class MovieRequestMapper {
    private String title;
    private int copies;
}
