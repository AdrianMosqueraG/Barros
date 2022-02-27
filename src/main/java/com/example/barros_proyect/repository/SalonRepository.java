package com.example.barros_proyect.repository;

import com.example.barros_proyect.domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalonRepository extends JpaRepository<Salon, Integer>, JpaSpecificationExecutor<Salon> {
}
