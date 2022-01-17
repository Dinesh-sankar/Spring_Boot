package com.example.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movies.model.Movie;

public interface MovieListRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByActor(String name);
	
}
