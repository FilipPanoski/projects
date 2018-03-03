package config;

import controller.SearchMovieController;
import controller.SuggestMovieController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.SearchMovieService;
import service.SuggestMovieService;

@Configuration
public class EndpointConfig {

    /**
     * @param searchMovieService service which helps with searching for movies.
     */
    @Bean
    public SearchMovieController searchMovieController(SearchMovieService searchMovieService) {
        return new SearchMovieController(searchMovieService);
    }

    /**
     * @param suggestMovieService service which helps with getting a random movie.
     */
    @Bean
    public SuggestMovieController suggestMovieController(SuggestMovieService suggestMovieService) {
        return new SuggestMovieController(suggestMovieService);
    }
}
