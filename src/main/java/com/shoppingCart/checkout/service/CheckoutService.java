package com.shoppingCart.checkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingCart.checkout.model.Checkout;

@RestController
public class CheckoutService implements ICheckoutService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	@PostMapping("/checkout")
	public void checkout(@Validated @RequestBody Checkout checkout) {

		// order confirmation email
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("librarykarachi@gmail.com");
		message.setTo(checkout.getEmail());
		message.setSubject("Order Placed Successfully....!");
		message.setText("Dear " + checkout.getFullName()
				+ "\n\nYour order has been placed successfully and order will be deliverd at  " + checkout.getAddress()
				+ "\nyour tracking id is xxxx-xxxx-xxxx.\nThanks ");
		javaMailSender.send(message);
		System.out.println("Mail send successfully.");
	}
}
