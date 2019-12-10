package infraestructura;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface VehiclesRepository  extends Repository<Vehicles, Integer> {
	
	List<Vehicles>findAll();
	
	Vehicles findOne(int id);
	Vehicles save(Vehicles vehicle);
	void delete (Vehicles vehicle);
	

}
