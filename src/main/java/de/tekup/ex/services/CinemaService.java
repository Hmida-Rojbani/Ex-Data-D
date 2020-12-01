package de.tekup.ex.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

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
	
	// Number of Male & Female Star who born in a given period
	public Map<Character, Long> getNumberMaleAndFemale(LocalDate dateBegin, LocalDate dateEnd) {
		List<Star> stars = reposStar.findAll();
		int male=0,female=0;
		for (Star star : stars) {
			if(star.getBirthDate().isAfter(dateBegin) && star.getBirthDate().isBefore(dateEnd)) {
				if (star.getGendre() == 'M') {
					male++;
				}else {
					female++;
				}
			}
		}
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('M', male);
		map.put('F', female);
		
		//return map;
		
		return reposStar.findAll()
		.stream()
		.filter(star -> star.getBirthDate().isAfter(dateBegin) && star.getBirthDate().isBefore(dateEnd))
		.collect(Collectors.groupingBy(star -> star.getGendre(), Collectors.counting()));
		
		
	}

}
