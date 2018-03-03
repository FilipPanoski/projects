package service.impl;

import model.Movie;
import model.MovieJson;
import model.MovieResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.MovieMapperService;
import service.SearchMovieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchMovieServiceImpl implements SearchMovieService {

    private RestTemplate restTemplate;
    private String searchUrl;
    private MovieMapperService movieMapperService;

    @Autowired
    public SearchMovieServiceImpl(RestTemplate restTemplate, String searchUrl, MovieMapperService movieMapperService) {
        this.restTemplate = restTemplate;
        this.searchUrl = searchUrl;
        this.movieMapperService = movieMapperService;
    }

    /**
     * {@inheritDoc}
     */
    public List<Movie> searchMovies(String movieName) {
        Map query = new HashMap<String, String>();
        query.put("name", movieName);
        MovieJson jsonResponse = restTemplate.getForObject(searchUrl, MovieJson.class, query);
        List<MovieResultJson> jsonResults = jsonResponse.getResults();
        return movieMapperService.mapToMovieList(jsonResults);
    }
}
