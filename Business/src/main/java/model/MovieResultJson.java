package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a class that represents the json variable results from model.MovieJson.class.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MovieResultJson {

    @JsonProperty("vote_count")
    private Integer voteCount;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("video")
    private Boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("title")
    private String title;
    @JsonProperty("popularity")
    private Double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds = null;
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("adult")
    private Boolean adult;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("vote_average")
    public Double getVoteAverage() {
        return voteAverage;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("genre_ids")
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("poster_path")
    public String getPosterPath() {
        return posterPath;
    }
}
