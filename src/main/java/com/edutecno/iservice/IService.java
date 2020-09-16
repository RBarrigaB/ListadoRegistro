package com.edutecno.iservice;

import java.util.List;

import com.edutecno.model.Contact;

public interface IService {

	public List<Contact> getDataInput();

	public void setDataInput(Contact contacto);
	
	public void deleteDataInput(int id);
}
