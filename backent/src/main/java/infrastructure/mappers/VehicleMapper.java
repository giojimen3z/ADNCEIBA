package infrastructure.mappers;

import java.util.List;

import dominio.Vehicle;
import infrastructure.repository.entity.VehiclesJpa;

public class VehicleMapper {
	
	public static VehiclesJpa toRepository(Vehicle vehicle) {
		
		VehiclesJpa vehic = new VehiclesJpa();
		
		vehic.setIdVehicle(vehicle.getIdVehicle());
		
		return vehic;
		
		
	}
	
	public static Vehicle toDomain(VehiclesJpa vehicle) {
		
		 Vehicle vehic = new Vehicle(); 
				
		vehic.setIdVehicle(vehicle.getIdVehicle());
		
		return vehic;
		
		
	}

	public static List<Vehicle> toDomain(List<VehiclesJpa> findAll) {
		
		 List<VehiclesJpa> listBase = findAll;
		 
		 List<Vehicle> listReceptor =null;
		 
		 for (int i=0; i < listBase.size();i++) {
			 
		 }
		
		

		return null;
	}
	
	
	
}
