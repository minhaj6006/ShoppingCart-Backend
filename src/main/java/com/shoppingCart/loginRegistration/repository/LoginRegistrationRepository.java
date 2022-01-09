package com.shoppingCart.loginRegistration.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shoppingCart.loginRegistration.model.LoginRegistration;

@Repository
public class LoginRegistrationRepository implements ILoginRegistrationRepository {

	private Object[] sqlArgs;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean authenticate(String email, String password) {

		String sql = "select exists( select * from credentials " + "where email = ? and password = ? "
				+ "and status = 'active')";
		this.sqlArgs = new Object[] { email, password };
		@SuppressWarnings("deprecation")
		Integer accountValid = jdbcTemplate.queryForObject(sql, sqlArgs, Integer.class);
		return (accountValid == 1) ? true : false;
	}

	@Override
	public void registration(LoginRegistration loginRegistration) {

		String SQL = "INSERT INTO credentials (email, password, status)" + " VALUE (?, ?, ?)";
		this.sqlArgs = new Object[] { loginRegistration.getEmail(), loginRegistration.getPassword(), "active" };
		jdbcTemplate.update(SQL, this.sqlArgs);
	}

}
