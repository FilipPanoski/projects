package service;

import model.Movie;

import java.util.List;

/**
 * Service which looks for movies in themoviedb.org api.
 */
public interface SearchMovieService {


    /**
     * Searches for all movies containing the movieName argument as the name of the movie.
     *
     * @param movieName the name of the movie/s being searched.
     * @return a list of all movies containing the corresponding arguments.
     */
    List<Movie> searchMovies(String movieName);
}
