package com.pedrogomes.cursmc.services;

import org.springframework.mail.SimpleMailMessage;

import com.pedrogomes.cursmc.domain.Pedido;

public interface EmailService {

	void senderOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
	
}
