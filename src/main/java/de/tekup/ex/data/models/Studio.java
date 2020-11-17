package de.tekup.ex.data.models;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "studios")
@EqualsAndHashCode(of = {"name"})
public class Studio {

	@Id
	@Column(length = 30)
	private String name;
	
	@Column(length = 70)
	private String address;
	@JsonIgnore
	@OneToMany(mappedBy = "studio")
	private List<Movie> movies;
}
