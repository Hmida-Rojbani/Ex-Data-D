package de.tekup.ex.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.data.models.Star;

public interface StarRepository extends JpaRepository<Star, String>{

}
