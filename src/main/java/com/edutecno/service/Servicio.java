package com.edutecno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.iservice.IService;
import com.edutecno.model.Contact;

@Service
public class Servicio implements IService {

	@Autowired
	Contact contact;
	private List<Contact> listaContactos;

	public Servicio(List<Contact> dataInput) {
		this.listaContactos = dataInput;
		dataInput.clear();
	}

	public List<Contact> getDataInput() {
		return listaContactos;
	}

	public void setDataInput(Contact contacto) {

		if (contacto != null) {
			listaContactos.add(contacto);
		}
	}

	public void deleteDataInput(int id) {

		if (id <= listaContactos.size()) {
			getDataInput().remove(id - 1);
			for (int i = 0; i < listaContactos.size(); i++) {
				listaContactos.get(i).setIdContacto(i + 1);
			}
		}

	}
}
