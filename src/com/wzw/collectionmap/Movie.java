package com.wzw.collectionmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Movie {
    private List<String> movies;
    public Movie(String... movies) {
        this.movies = new ArrayList<>();
        for (String movie: movies) {
            this.movies.add(movie);
        }
        Iterator<String> iterator = this.movies.iterator();
    }
    private class MovieGenerator implements Generator {
        private int size = movies.size();
        private int i = 0;
        public void next() {
            i++;
        }
        public String current() {
            return movies.get(i);
        }
        public boolean end() {
            return i == size;
        }
        public void reset(){

        }
    }

    public Generator generator() {
        return new MovieGenerator();
    }

    public static void main(String[] args) {
        Movie movie = new Movie("a", "b", "c", "d");
        Generator generator = movie.generator();
        while(!generator.end()) {
            System.out.println(generator.current());
            generator.next();
        }
        generator.reset();
    }
}

interface Generator {
    public void next();
    public Object current();
    public boolean end();
    public void reset();
}
