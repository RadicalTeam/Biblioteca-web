package library.controller;

import library.LibraryService.LibraryService;
import library.ResponseMessage.LoginMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class LibraryController {
    private LibraryService libraryService = new LibraryService();

    public void setResourceType(String resourceType) {
        libraryService.setResourceType(resourceType);
    }

    @RequestMapping("/login")
    public LoginMessage greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return libraryService.login(name);
    }

    @GetMapping("/movies/list")
    public List<String> getMovieList() {
        return libraryService.getMovieList();
    }
}
