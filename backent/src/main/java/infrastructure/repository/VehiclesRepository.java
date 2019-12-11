package infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import infrastructure.repository.entity.VehiclesJpa;

public interface VehiclesRepository  extends JpaRepository<VehiclesJpa, Integer> {
 
	
}
