package service.impl;

import exception.NoResourcesFoundException;
import mapper.MovieMapper;
import model.Movie;
import model.MovieResultJson;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.MovieMapperService;
import utils.GenreUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieMapperServiceImpl implements MovieMapperService {

    private MovieMapper movieMapper;

    @Autowired
    public MovieMapperServiceImpl() {
        movieMapper = Mappers.getMapper(MovieMapper.class);
    }

    /**
     * {@inheritDoc}
     */
    public List<Movie> mapToMovieList(List<MovieResultJson> jsonResults) {
        List<Movie> movieList = jsonResults.stream().map(result -> mapToMovie(result)).collect(Collectors.toList());
        if (movieList.size() == 0) {
            throw new NoResourcesFoundException("No movies were found.");
        }
        return movieList;
    }

    private Movie mapToMovie(MovieResultJson result) {
        Movie movie = movieMapper.resultJsonToMovie(result);
        movie.setGenres(GenreUtils.parseJsonGenreToGenreList(result.getGenreIds()));
        return movie;
    }
}
