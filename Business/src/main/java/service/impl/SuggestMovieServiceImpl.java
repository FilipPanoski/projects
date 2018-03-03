package service.impl;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.MovieMapperService;
import service.SuggestMovieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class SuggestMovieServiceImpl implements SuggestMovieService {

    private RestTemplate restTemplate;
    private String discoverUrl;
    private MovieMapperService movieMapperService;

    @Autowired
    public SuggestMovieServiceImpl(RestTemplate restTemplate, String discoverUrl, MovieMapperService movieMapperService) {
        this.restTemplate = restTemplate;
        this.discoverUrl = discoverUrl;
        this.movieMapperService = movieMapperService;
    }

    /**
     * {@inheritDoc}
     */
    public Movie suggestRandomMovie(List<Genre> genres) {
        Map query = new HashMap<String, String>();
        query.put("genres", genres.stream().map(genre -> GenreJson.valueOf(genre.toString()).getId()).toArray());
        MovieJson jsonResponse = restTemplate.getForObject(discoverUrl, MovieJson.class, query);
        List<MovieResultJson> jsonResults = jsonResponse.getResults();
        List<Movie> qualifiedMovies = movieMapperService.mapToMovieList(jsonResults);
        return getRandomMovie(qualifiedMovies);
    }

    private Movie getRandomMovie(List<Movie> movieList) {
        int randomIndex = new Random().nextInt(movieList.size());
        return movieList.get(randomIndex);
    }
}
