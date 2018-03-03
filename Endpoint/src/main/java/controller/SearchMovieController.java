package controller;

import model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.SearchMovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class SearchMovieController {

    private SearchMovieService searchMovieService;

    @Autowired
    public SearchMovieController(SearchMovieService searchMovieService) {
        this.searchMovieService = searchMovieService;
    }

    /**
     * Searches for movies containing the argument movieName as a name of the movies.
     *
     * @param movieName the name of the movie the user is looking for.
     * @return a list of all qualified movies based on the argument.
     */
    @GetMapping
    public List<Movie> getMovies(@RequestParam("name") String movieName) {
        return searchMovieService.searchMovies(movieName);
    }
}
