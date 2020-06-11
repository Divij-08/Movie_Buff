package com.divij.moviebuff.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genre_ids")
    private List<Integer>genreIds=new ArrayList<Integer>();
    @SerializedName("id")
    private Integer id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath ;
    @SerializedName("popularity")
    private Double popularity;
    @SerializedName("vote_count")
    private Integer voteCount;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private Double voteAverage;

public Movie(String posterPath,boolean adult,String overview, String releaseDate,Double voteAverage,boolean video,Integer voteCount
,Double popularity,String backdropPath,String title,String originalLanguage,String originalTitle,Integer id,List<Integer>genreIds){
    this.posterPath=posterPath;
    this.adult=adult;
    this.overview=overview;
    this.releaseDate=releaseDate;
    this.voteAverage=voteAverage;
    this.popularity=popularity;
    this.video=video;
    this.voteCount=voteCount;
    this.backdropPath=backdropPath;
    this.title=title;
    this.originalLanguage=originalLanguage;
    this.originalTitle=originalTitle;
    this.genreIds=genreIds;
    this.id=id;

}
String baseImageurl = "https://image.tmdb.org/t/p/w500";

public String getPosterPath(){
    return "https://image.tmdb.org/t/p/w500"+posterPath;
}
public void setPosterPath(String posterPath){
    this.posterPath = posterPath;
}
public boolean isAdult(){
    return adult;
}
public void setAdult(boolean adult){
    this.adult = adult;
}
public String getOverview(){
        return overview;
}
public void setOverview(String overview){
    this.overview = overview;
}
public String getReleaseDate(){
        return releaseDate;
}
public void setReleaseDate(String releaseDate){
    this.releaseDate=releaseDate;
}
    public Double getVoteAverage(){
        return voteAverage;
    }
    public void setVoteAverage(Double voteAverage){
        this.voteAverage = voteAverage;
    }
    public Double getPopularity (Double popularity){
        return popularity;
    }
    public void setPopularity(Double popularity){
        this.popularity=popularity;
    }
    public boolean getVideo(){
        return video;
    }
    public void setVideo(boolean video){
        this.video=video;
    }
    public Integer getVoteCount(){
        return voteCount;
    }
    public void setVoteCount(Integer voteCount){
        this.voteCount = voteCount;
    }
    public String getBackdropPath(){
        return backdropPath;
    }
    public void setBackdropPath(String backdropPath){
        this.backdropPath = backdropPath;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getOriginalTitle(){
        return originalTitle;
    }
    public void setOriginalTitle(String originalTitle){
        this.originalTitle = originalTitle;
    }
    public String getOriginalLanguage(){
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage){
        this.originalLanguage = originalLanguage;
    }
    public List<Integer>getGenreIds(){
        return genreIds;
    }
    public void setGenreIds(List<Integer>genreIds){
        this.genreIds = genreIds;
    }
    public Integer getid(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

}
