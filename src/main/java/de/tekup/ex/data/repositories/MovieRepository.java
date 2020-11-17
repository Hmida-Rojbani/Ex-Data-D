package de.tekup.ex.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.data.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {

}
