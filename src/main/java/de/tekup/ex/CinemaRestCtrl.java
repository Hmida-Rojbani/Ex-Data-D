package de.tekup.ex;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.ex.data.models.Studio;
import de.tekup.ex.services.CinemaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CinemaRestCtrl {
	
	private CinemaService service;
	
	@GetMapping("/api/cinema/star/{name}/studios")
	public List<Studio> getStudios(@PathVariable("name") String starName){
		return service.getStudiosByStar(starName);
	}

}
