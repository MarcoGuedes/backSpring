package com.backSpring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backSpring.Models.Service;
import com.backSpring.Repo.ServiceRepo;

@RestController
@RequestMapping("/service")
@CrossOrigin("localhost:4200")
public class ServiceController {
	@Autowired
	private ServiceRepo servRep;
	
	@GetMapping("/all")
	 public List<Service> getAllServices () {
		 return servRep.findAll();
	 }

	 @GetMapping("/find/{id}")
	 public Service getServiceById (@PathVariable("id") Long id) {
		 return servRep.getById(id);
	 }

	 //@GetMapping("/find/user/{id}")
	 //public List<Service> getServiceByUserId (@PathVariable("id") Long id) {
	 //	 return servRep.findServiceByUserId(id);
	 //}
	 
	 @PostMapping("/add")
	 public HttpStatus addService(@RequestBody Service serv) {
		 servRep.save(serv);
		 return HttpStatus.CREATED;
	 }

	 @PutMapping("/update")
	 public HttpStatus updateService(@RequestBody Service serv) {
		 Service updateService = servRep.getById(serv.getId());
		 servRep.save(updateService);
		 return HttpStatus.OK;
	 }

	 @DeleteMapping("/delete/{id}")
	 public HttpStatus deleteService(@PathVariable("id") Long id) {
		 servRep.deleteById(id);
		 return HttpStatus.OK;
	 }
}
