package infraestructura;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiclesServiceImplements implements VehiclesService {
	@Autowired
	private VehiclesRepository repositorio;
	
	
	@Override
	public List<Vehicles> showVehicles() {
			
		return repositorio.findAll();
	}

	@Override
	public Vehicles listIds(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicles add(Vehicles vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicles edtit(Vehicles vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicles disable(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
