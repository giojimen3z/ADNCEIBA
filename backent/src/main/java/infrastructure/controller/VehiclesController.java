package infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aplication.handler.VehicleHandler;
import infrastructure.repository.entity.VehiclesJpa;


@CrossOrigin(origins = "http://localhost:4200" ,maxAge=3600)
@RestController
@RequestMapping({"/Vehicles"})
public class VehiclesController {
	
	@Autowired
	VehicleHandler handler;
	
	@GetMapping
	public List<VehiclesJpa> showVehicles(){
		 
		return handler.showVehicles();
		
	}
}
