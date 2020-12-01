package de.tekup.ex.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.stereotype.Service;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Star;
import de.tekup.ex.data.models.Studio;
import de.tekup.ex.data.repositories.MovieRepository;
import de.tekup.ex.data.repositories.StarRepository;
import de.tekup.ex.data.repositories.StudioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CinemaService {

	private MovieRepository reposMovie;
	private StudioRepository reposStudio;
	private StarRepository reposStar;

	public List<Studio> getStudiosByStar(String starName) {

		Star star = reposStar.findById(starName)
				.orElseThrow(() -> new NoSuchElementException("Star with name not found"));

		Set<Studio> studios = new HashSet<>();

		for (Movie movie : star.getMovies()) {
			studios.add(movie.getStudio());
		}

		return new ArrayList<>(studios);
	}

	public List<Movie> getColoredMoviesByStudio(String studioName) {
		Studio studio = reposStudio.findById(studioName)
				.orElseThrow(() -> new NoSuchElementException("Studio with name not found"));

		List<Movie> coloredMovies = new ArrayList<>();

		for (Movie movie : studio.getMovies()) {
			if (movie.getColor() == 1) {
				coloredMovies.add(movie);
			}
		}
		return coloredMovies;
	}

}
