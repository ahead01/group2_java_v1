/**
 * 
 */
package com.software.group2.controllers;

import java.util.Optional;

/**
 * @author Austin
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.software.group2.entities.Admin;
import com.software.group2.repos.AdminRepo;



@Controller    // This means that this class is a Controller
@RequestMapping(path="/admin") // This means URL's start with /software (after Application path)
public class AdminCont {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private AdminRepo adminRepository;

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewAdmin (@RequestParam String pwd) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		Admin n = new Admin();
		n.setPwd(pwd);
		adminRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/getall")
	public @ResponseBody Iterable<Admin> getAllAdmins() {
		// This returns a JSON or XML with the users
		return adminRepository.findAll();
	}
	
	@GetMapping(path="/getone")
	public @ResponseBody Optional<Admin> getOneAdmin(@RequestParam Integer id) {
		// This returns a JSON or XML with the admin
		return adminRepository.findById(id);
	}
}
