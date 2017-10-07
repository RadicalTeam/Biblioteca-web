package library.api;

import library.ResponseMessage.LoginMessage;
import library.controller.LibraryController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GreetingApiTest {
    private LibraryController libraryController = new LibraryController();;

    @Test
    public void should_return_welcome_message_when_user_login() {
        LoginMessage exceptMessage = new LoginMessage("Jack", "Dear Jack! Welcome to our library!");
        LoginMessage response = libraryController.greeting("Jack");
        assertEquals(exceptMessage.getUserName(), response.getUserName());
        assertEquals(exceptMessage.getWelcomeMessage(), response.getWelcomeMessage());
    }

    @Test
    public void should_return_movie_list_when_user_view_list() {
        libraryController.setResourceType("test");
        List<String> exceptList = new ArrayList<>();
        exceptList.add("KaiTi");
        exceptList.add("Life of MiTi");
        assertEquals(exceptList, libraryController.getMovieList());
    }
}
