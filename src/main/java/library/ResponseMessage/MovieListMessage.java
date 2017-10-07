package library.ResponseMessage;

import java.util.List;
import java.util.Map;

public class MovieListMessage {
    private List<Map<String, String>> movieList;


    public MovieListMessage(List<Map<String, String>> movieList) {
        this.movieList = movieList;
    }
}
