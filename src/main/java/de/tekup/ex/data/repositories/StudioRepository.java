package de.tekup.ex.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.data.models.Studio;

public interface StudioRepository extends JpaRepository<Studio, String>{

}
