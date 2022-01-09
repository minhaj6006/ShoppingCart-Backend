package com.shoppingCart.loginRegistration.repository;

import com.shoppingCart.loginRegistration.model.LoginRegistration;

public interface ILoginRegistrationRepository {

	public Boolean authenticate(String email, String password);

	public void registration (LoginRegistration loginRegistration);


}

