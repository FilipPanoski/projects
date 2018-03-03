package service;

import model.Genre;
import model.Movie;

import java.util.List;

/**
 * Service which suggests a random movie from themoviedb.org api.
 */
public interface SuggestMovieService {

    /**
     * Gets a random movie based on the corresponding argument.
     *
     * @param genres the genres from which the movie suggestion is based on.
     * @return a random movie based on the criteria.
     */
    Movie suggestRandomMovie(List<Genre> genres);
}
