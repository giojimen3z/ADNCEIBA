package dominio.ports;

import java.util.List;

import dominio.Vehicle;

public interface VehicleRepository {

	List<Vehicle> getAll();
	
}

