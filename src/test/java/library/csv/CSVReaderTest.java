package library.csv;

import library.util.CSVReader;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CSVReaderTest {
    private CSVReader csvReader = new CSVReader("test");

    @Test
    public void should_return_movie_detail_when_given_a_valid_movie_name() throws Exception {
        Map<String, String> exceptBookDetail = new HashMap<>();
        exceptBookDetail.put("movieName", "KaiTi");
        exceptBookDetail.put("publishYear", "2010");
        exceptBookDetail.put("director", "Mark");
        exceptBookDetail.put("rate", "9.5");
        exceptBookDetail.put("totalQuantity", "20");
        exceptBookDetail.put("remainQuantity", "10");
        assertEquals(exceptBookDetail, csvReader.findMovieDetailByMovieName("KaiTi"));
    }

    @Test
    public void should_return_empty_map_when_given_a_invalid_book_name() {
        Map<String, String> exceptBookDetail = new HashMap<>();
        assertEquals(exceptBookDetail, csvReader.findMovieDetailByMovieName("C# Start"));
    }

}