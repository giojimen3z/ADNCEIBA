package aplication.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dominio.Vehicle;
import infrastructure.repository.VehiclesRepository;
import infrastructure.repository.entity.VehiclesJpa;

@Service
public class VehicleHandler {
	
	private  final VehiclesRepository repository;
	
	public VehicleHandler(final VehiclesRepository repository) {
		
		this.repository = repository;
	}
	public List<VehiclesJpa> showVehicles() {
		
		return repository.findAll();
	}
}
