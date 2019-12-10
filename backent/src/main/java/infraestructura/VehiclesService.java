package infraestructura;

import java.util.List;

public interface VehiclesService {
	
	List<Vehicles>showVehicles();
	Vehicles listIds(int id);
	Vehicles add(Vehicles vehicle);
	Vehicles edtit(Vehicles vehicle);
	Vehicles disable(int id);

}
