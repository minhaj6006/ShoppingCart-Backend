package com.shoppingCart.loginRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCart.loginRegistration.model.LoginRegistration;
import com.shoppingCart.loginRegistration.repository.ILoginRegistrationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginRegistrationService implements ILoginRegistrationService {

	@Autowired
	private ILoginRegistrationRepository loginRepo;

	@Override
	@GetMapping("/authenticate/{email}/{password}")
	public Boolean authenticate(@PathVariable String email, @PathVariable String password) {
		return loginRepo.authenticate(email, password);
	}

	@Override
	@PostMapping("/registration")
	public LoginRegistration registration(@Validated @RequestBody LoginRegistration registration) {
		loginRepo.registration(registration);
		return registration;
	}
}