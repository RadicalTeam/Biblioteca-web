package com.example.demo.api.test;

import com.example.demo.LibraryService.LibraryService;
import com.example.demo.ResponseMessage.LoginMessage;
import com.example.demo.controller.LibraryController;
import com.example.demo.util.CSVReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class GreetingApiTest {
    private LibraryController libraryController = new LibraryController();;
    private LibraryService libraryService = new LibraryService();
    private CSVReader csvReader = mock(CSVReader.class);

    @Test
    public void should_return_welcome_message_when_user_login() {
        LoginMessage exceptMessage = new LoginMessage("Jack", "Dear Jack! Welcome to our library!");
        LoginMessage response = libraryController.greeting("Jack");
        assertEquals(exceptMessage.getUserName(), response.getUserName());
        assertEquals(exceptMessage.getWelcomeMessage(), response.getWelcomeMessage());
    }
    

    @Test
    public void should_return_movie_list_when_user_view_list() {
//        String[] movieExample1 = new String[]{"KaiTi","2010","Mark","9.0","20","10"};
//        String[] movieExample2 = new String[]{"Life of MiTi","2010","Jack","9.8","20","10"};
//        List<Map<String,String>> allMovies = new ArrayList<>();
//        allMovies.add(csvReader.buildMovieDetailMap(movieExample1));
//        allMovies.add(csvReader.buildMovieDetailMap(movieExample2));
//        when(csvReader.findAllMovies()).thenReturn(allMovies);
//        Map<String,String> example1Detail = csvReader.buildMovieDetailMap(movieExample1);
//        when(csvReader.findMovieDetailByMovieName("KaiTi")).thenReturn(example1Detail);
        List<String> exceptList = new ArrayList<>();
        exceptList.add("KaiTi");
        exceptList.add("Life of MiTi");
        assertEquals(exceptList, libraryController.getMovieList());
    }
}
