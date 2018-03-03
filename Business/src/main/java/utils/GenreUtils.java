package utils;

import model.Genre;
import model.GenreJson;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that helps with parsing themoviedb.org genre ids to model.Genre objects.
 */
public class GenreUtils {

    /**
     * Parses a list of themoviedb.org genre ids to their corresponding model.Genre representations.
     * Removes all genre ids that are not used in the model.Genre.class.
     *
     * @param jsonIds the list containing themoviedb.org genre ids.
     * @return a list of model.Genre.class genres.
     */
    public static List<Genre> parseJsonGenreToGenreList(List<Integer> jsonIds) {
        List<GenreJson> jsonGenres = jsonIds.stream().map(id -> GenreJson.getGenre(id)).collect(Collectors.toList());
        jsonGenres.removeAll(Collections.singleton(null));

        return jsonGenres.stream().map(genre -> Genre.valueOf(genre.toString())).collect(Collectors.toList());
    }
}
