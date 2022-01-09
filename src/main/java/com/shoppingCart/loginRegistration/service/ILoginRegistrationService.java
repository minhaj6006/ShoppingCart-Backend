package com.shoppingCart.loginRegistration.service;

import com.shoppingCart.loginRegistration.model.LoginRegistration;

public interface ILoginRegistrationService {

	public Boolean authenticate(String userName, String password);

	public LoginRegistration registration (LoginRegistration loginRegistration);

}
