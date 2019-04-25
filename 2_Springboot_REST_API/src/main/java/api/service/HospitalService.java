package api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import api.model.Hospital;

//@Service:	defines a class as service

@Service
public class HospitalService {

	public HospitalService() {

	}
	
	//Creates a dummy list
	private List<Hospital> hospitalList = new ArrayList<>(
			Arrays.asList(new Hospital(1001, "Apollo Hospital", "Chennai", 3.8),
					new Hospital(1002, "Global Hospital", "Chennai", 3.5),
					new Hospital(1003, "VCare Hospital", "Bangalore", 3)));

	public List<Hospital> getAllHospitals() {
		return hospitalList;
	}

	public Hospital getHospital(int id) {
		return hospitalList.stream().filter(c -> c.getId() == (id)).findFirst().get();
	}
	
	public void addHospital(Hospital hospital) {
		hospitalList.add(hospital);
	}
	
	public void updateHospital(Hospital hospital) {
		hospitalList.removeIf((h) -> h.getId() == hospital.getId());
		hospitalList.add(hospital);
	}

	public void deleteHospital(Hospital hospital) {
		hospitalList.removeIf((h) -> h.getId() == hospital.getId());
	}

}
