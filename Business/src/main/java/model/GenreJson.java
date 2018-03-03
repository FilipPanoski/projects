package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration which holds the correspondence between themoviedb.org genre ids and model.Genre.class objects.
 */
public enum GenreJson {
    Action(28),
    Adventure(12),
    Comedy(35),
    Crime(80),
    Documentary(99),
    Drama(18),
    Fantasy(14),
    History(36),
    Horror(27),
    Mystery(9648),
    Romance(10749),
    SciFi(878),
    Thriller(53);

    private int id;
    private static Map<Integer, GenreJson> map = new HashMap<>();

    GenreJson(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    /**
     * Puts all genres into a map from which you can search by themoviedb.org specific genre id.
     */
    static {
        for (GenreJson genre: GenreJson.values()) {
            map.put(genre.id, genre);
        }
    }

    /**
     * Searches for a specific genre by a themoviedb.org id.
     *
     * @param id is the unique themoviedb.org id for a particular genre.
     * @return the correspodning GenreJson.class genre.
     */
    public static GenreJson getGenre(Integer id) {
        return map.get(id);
    }
}
