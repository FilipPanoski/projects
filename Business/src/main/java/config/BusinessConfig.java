package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import service.MovieMapperService;
import service.SearchMovieService;
import service.SuggestMovieService;
import service.impl.MovieMapperServiceImpl;
import service.impl.SearchMovieServiceImpl;
import service.impl.SuggestMovieServiceImpl;

@Configuration
public class BusinessConfig {

    /**
     * @param restTemplate the RestTemplate which is used for consuming themoviedb.org api.
     * @param searchUrl the url for themoviedb.org search functionality.
     * @param movieMapperService service which helps with mapping the json response to relevant moviefinder objects.
     */
    @Bean
    public SearchMovieService searchMovieService(RestTemplate restTemplate,
                                                 @Value("${themoviedb.searchUrl}") String searchUrl,
                                                 MovieMapperService movieMapperService) {

        return new SearchMovieServiceImpl(restTemplate, searchUrl, movieMapperService);
    }

    /**
     * @param restTemplate the RestTemplate which is used for consuming themoviedb.org api.
     * @param discoverUrl the url for themoviedb.org discover functionality.
     * @param movieMapperService service which helps with mapping the json response to relevant moviefinder objects.
     */
    @Bean
    public SuggestMovieService suggestMovieService(RestTemplate restTemplate,
                                                   @Value("${themoviedb.discoverUrl}") String discoverUrl,
                                                   MovieMapperService movieMapperService) {

        return new SuggestMovieServiceImpl(restTemplate, discoverUrl, movieMapperService);
    }

    @Bean
    public MovieMapperService movieMapperService() {
        return new MovieMapperServiceImpl();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
