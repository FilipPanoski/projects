package service;

import model.Movie;
import model.MovieResultJson;

import java.util.List;

/**
 * Service which maps themoviedb.org api json movies to moviefinder object model movies.
 */
public interface MovieMapperService {

    /**
     * Maps from model.MovieResultJson.class to model.Movie.class objects.
     *
     * @param jsonResults the movie results of themoviedb.org api search.
     * @return a list of mapped movies.
     */
    List<Movie> mapToMovieList(List<MovieResultJson> jsonResults);
}
