package model;

import lombok.Data;
import model.Genre;

import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {

    private String id;
    private String name;
    private Integer rating;
    private String releaseDate;
    private String posterPath;
    private List<Genre> genres = new ArrayList<Genre>();
}
