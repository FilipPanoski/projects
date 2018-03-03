package mapper;

import model.Movie;
import model.MovieResultJson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapping interface which maps objects from model.MovieResultJson.class to model.Movie class using MapStruct.
 */
@Mapper(componentModel = "spring")
public interface MovieMapper {

    /**
     * Maps a MovieResultJson.class object to a model.Movie.class object.
     * The new mapped movie has a mapped id, name, rating and release date.
     * The genre mapping however, is not done by this interface.
     *
     * @param resultJson an object of MovieResultJson.class that is a json representation of a movie.
     * @return a movie object from the model.Movie.class.
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "name")
    @Mapping(source = "voteAverage", target = "rating")
    @Mapping(source = "releaseDate", target = "releaseDate")
    Movie resultJsonToMovie(MovieResultJson resultJson);
}
