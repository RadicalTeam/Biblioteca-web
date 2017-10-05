package com.example.demo.util;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    private String moviesListFilePath;

    public CSVReader() {
        this.moviesListFilePath = getResourcePath();
    }

    private String getResourcePath() {
        File locateFile = new File(this.getClass().getResource("/").getPath());
        return locateFile.getParentFile().getPath() +
                File.separator +
                "resources" +
                File.separator +
                "movies-list.csv";
    }

    public Map<String, String> buildMovieDetailMap(String[] singleBookDetailArray) {
        Map<String, String> movieDetail = new HashMap<>();
        movieDetail.put("movieName", singleBookDetailArray[0]);
        movieDetail.put("publishYear", singleBookDetailArray[1]);
        movieDetail.put("director", singleBookDetailArray[2]);
        movieDetail.put("rate", singleBookDetailArray[3]);
        movieDetail.put("totalQuantity", singleBookDetailArray[4]);
        movieDetail.put("remainQuantity", singleBookDetailArray[5]);
        return movieDetail;
    }

    public Map<String, String> findMovieDetailByMovieName(String movieName) {
        BufferedReader bufferReader;
        String singleMovieDetailLine;
        String csvSplitBy = ",";
        Map<String, String> selectMovieDetail = new HashMap<>();
        try {
            bufferReader = new BufferedReader(new FileReader(moviesListFilePath));
            while ((singleMovieDetailLine = bufferReader.readLine()) != null) {
                String[] singleBookDetailArray = singleMovieDetailLine.split(csvSplitBy);
                if (singleBookDetailArray[0].equalsIgnoreCase(movieName)) {
                    selectMovieDetail = buildMovieDetailMap(singleBookDetailArray);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return selectMovieDetail;
    }

    public List<Map<String, String>> findAllMovies() {
        List<Map<String, String>> bookList = new ArrayList<>();
        BufferedReader bufferReader;
        String singleMovieDetailLine;
        String csvSplitBy = ",";
        try {
            bufferReader = new BufferedReader(new FileReader(moviesListFilePath));
            while ((singleMovieDetailLine = bufferReader.readLine()) != null) {
                String[] singleMovieDetailArray = singleMovieDetailLine.split(csvSplitBy);
                bookList.add(buildMovieDetailMap(singleMovieDetailArray));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void checkoutBook(String movieName) throws IOException {
        List<Map<String, String>> moviesList = findAllMovies();
        for (Map<String, String> movie : moviesList) {
            if (movie.get("movieName").equalsIgnoreCase(movieName)) {
                Integer remainQuantity = Integer.parseInt(movie.get("remainQuantity")) - 1;
                movie.replace("remainQuantity", remainQuantity.toString());
            }
        }
        writeNewCsvFile(moviesList);
    }

    public void returnBook(String movieName) throws IOException {
        List<Map<String, String>> movieList = findAllMovies();
        for (Map<String, String> movie : movieList) {
            if (movie.get("movieName").equalsIgnoreCase(movieName)) {
                Integer remainQuantity = Integer.parseInt(movie.get("remainQuantity")) + 1;
                movie.replace("remainQuantity", remainQuantity.toString());
            }
        }
        writeNewCsvFile(movieList);
    }

    private void writeNewCsvFile(List<Map<String, String>> moviesList) throws IOException {
        FileWriter writeIntoFile = new FileWriter(getResourcePath());
        BufferedWriter bufferedWriter = new BufferedWriter(writeIntoFile);
        for (Map<String, String> movie : moviesList) {
            String line = "";
            line += movie.get("movieName") + ","
                    + movie.get("publishYear") + ","
                    + movie.get("director") + ","
                    + movie.get("rate") + ","
                    + movie.get("totalQuantity") + ","
                    + movie.get("remainQuantity") + "\n";
            bufferedWriter.write(line);
        }
        bufferedWriter.close();
    }
}