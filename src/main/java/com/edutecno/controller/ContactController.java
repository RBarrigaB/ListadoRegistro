package com.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.model.Contact;
import com.edutecno.service.Servicio;

@Controller
public class ContactController {
	
	@Autowired
	Servicio service;
	
	@RequestMapping(value="contactManager", method = RequestMethod.GET)
	public String inicio(ModelMap model) {
		return "contactManager";
	}
	
	@RequestMapping(value="addContact", method = RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contacto") Contact contact) {
	
		contact.setIdContacto(service.getDataInput().size() + 1);
		service.setDataInput(contact);
		model.put("ContactList", service.getDataInput());

		return "contactManager";
	}
	
	@RequestMapping(value="deleteContact", method = RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") int id) {

		service.deleteDataInput(id);
		model.put("ContactList", service.getDataInput());
		
		return "contactManager";
	}
	
	
}
