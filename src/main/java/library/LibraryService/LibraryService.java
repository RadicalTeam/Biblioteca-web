package library.LibraryService;

import library.ResponseMessage.LoginMessage;
import library.util.CSVReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class LibraryService {
    private static final String template = "Dear %s! Welcome to our library!";

    private CSVReader csvReader = new CSVReader("main");

    public void setResourceType(String resourceType) {
        csvReader.setCSVResourceType(resourceType);
    }

    public LoginMessage login(String userName) {
        return new LoginMessage(userName, String.format(template, userName));
    }

    public List<String> getMovieList() {
        List<Map<String,String>> allMoviesDetailList = csvReader.findAllMovies();
        List<String> moviesList = new ArrayList<>();
        for (Map<String, String> movie : allMoviesDetailList) {
            moviesList.add(movie.get("movieName"));
        }
        return moviesList;
    }
}
