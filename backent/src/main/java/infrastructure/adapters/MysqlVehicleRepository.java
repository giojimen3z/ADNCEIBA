package infrastructure.adapters;

import java.util.List;
import org.springframework.stereotype.Repository;


import dominio.Vehicle;
import dominio.ports.VehicleRepository;
import infrastructure.mappers.VehicleMapper;
import infrastructure.repository.VehiclesRepository;
import infrastructure.repository.entity.VehiclesJpa;


@Repository
public class MysqlVehicleRepository implements VehicleRepository {
	
	
	
	private VehiclesRepository repositorio;
	
	
	public MysqlVehicleRepository(final  VehiclesRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<Vehicle> getAll() {
		
		return VehicleMapper.toDomain(repositorio.findAll()) ;
	}
	
	
}
