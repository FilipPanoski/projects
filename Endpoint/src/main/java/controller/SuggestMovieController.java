package controller;

import model.Genre;
import model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.SuggestMovieService;

import java.util.List;

@RestController
@RequestMapping("/movies/suggestions")
public class SuggestMovieController {

    private SuggestMovieService suggestMovieService;

    @Autowired
    public SuggestMovieController(SuggestMovieService suggestMovieService) {
        this.suggestMovieService = suggestMovieService;
    }

    /**
     * Gets a random movie based on the genres argument as the genres of the movie the user is looking for.
     *
     * @param genres the different genres of the movie that the user wants.
     * @return a random movie based on the genres as a criteria.
     */
    @GetMapping
    public Movie getRandomMovie(@RequestParam("genres") List<Genre> genres) {
        return suggestMovieService.suggestRandomMovie(genres);
    }
}
