package api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.model.Hospital;
import api.service.HospitalService;

//@RestController:	defines a rest controller
//@RequestMapping("/test/"):	maps the request to specified path, also defines the request type for methods

@RestController
@RequestMapping("/test/")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@RequestMapping(value = "/hospital/{id}", method = RequestMethod.GET)
	public @ResponseBody Hospital getHospital(@PathVariable("id") int id) throws Exception {
		Hospital hospital = hospitalService.getHospital(id);
		return hospital;
	}

	@RequestMapping(value = "/hospitals", method = RequestMethod.GET)
	public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
		return hospitalService.getAllHospitals();
	}
	
	@RequestMapping(value = "/hospital", method = RequestMethod.POST)
	public ResponseEntity<String> addHospital(@RequestBody Hospital hospital) {
		hospitalService.addHospital(hospital);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/hospital", method = RequestMethod.PUT)
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
		hospitalService.updateHospital(hospital);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/hospital", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) {
		hospitalService.deleteHospital(hospital);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
