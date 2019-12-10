package infraestructura;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "vehicles")
public class Vehicles {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vehicle;
	@Column
	private String plate;
	@Column
	private String vehicle_type;
	@Column
	private int cc;
	
	public int getId_vehicle() {
		return id_vehicle;
	}
	public void setId_vehicle(int id_vehicle) {
		this.id_vehicle = id_vehicle;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	
		
	
	
}
