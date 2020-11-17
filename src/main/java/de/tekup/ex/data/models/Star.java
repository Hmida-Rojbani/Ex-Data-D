package de.tekup.ex.data.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "stars")
public class Star {
	@Id
	@Column(length = 50)
	private String name;
	
	@Column(length = 70)
	private String address;

	private char gendre;
	
	private LocalDate birthDate;
	
	@ManyToMany(mappedBy = "stars")
	private List<Movie> movies;
}
