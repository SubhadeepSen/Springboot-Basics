package api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.Hospital;
import api.repository.HospitalRepository;

//@Service:	defines a class as service

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	public HospitalService() {
	}
	
	//This method is used to initialize the hospital repository
	public void initHospitalRepository() {
		hospitalRepository.save(new Hospital(1001, "Apollo Hospital", "Chennai", 3.8));
		hospitalRepository.save(new Hospital(1002, "Global Hospital", "Chennai", 3.5));
		hospitalRepository.save(new Hospital(1003, "VCare Hospital", "Bangalore", 3));
	}

	public List<Hospital> getAllHospitals() {
		List<Hospital> hospitalList = new ArrayList<Hospital>();
		//find all the hospital objects from the repository and add them to hospitalList
		hospitalRepository.findAll().forEach(hospitalList::add);
		return hospitalList;

	}

	public Hospital getHospital(int id) {
		//find a particular object for the given id
		return hospitalRepository.findOne(id);
	}
	
	public void addHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}
	
	public void updateHospital(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	public void deleteHospital(Hospital hospital) {
		hospitalRepository.delete(hospital);
	}

}
