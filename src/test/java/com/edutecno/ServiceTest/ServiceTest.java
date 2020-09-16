package com.edutecno.ServiceTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.edutecno.model.Contact;
import com.edutecno.service.Servicio;

public class ServiceTest {

	Contact contact;
	List<Contact> Contacts;
	Servicio servicio;
	
	@Before
	public void Load() {
		//Antes que nada, se instancian un nuevo objeto
		//una lista de contactos y una nueva instancia
		//de la clase servicio con la lista de contactos
		//respectiva. Los cuales serán usados en los métodos
		//a continuación
		contact = new Contact();
		Contacts = new ArrayList<Contact>();
		servicio = new Servicio(Contacts);
	}
	
	@Test
	public void testListaExistente() {
		
		//Se verifica si la instancia de servicio contiene un 
		//ArrayList de tipo Contact vacío y se confirma su existencia
		assertEquals(new ArrayList<Contact>(), servicio.getDataInput());
	}
	
	@Test
	public void testListaVacia() {
		
		//Se verifica que el tamaño de la lista sea 0, ya que está vacía.
		assertEquals(0, servicio.getDataInput().size());
	}
	
	@Test
	public void testGuardarContactoEnLista() {
		
		//Se agrega contacto, seteando manualmente el objeto contact
		contact.setNombre("Reinaldo");
		contact.setApellidoP("Barriga");
		contact.setApellidoM("Bauden");
		contact.setDireccion("Prueba 123");
		contact.setTelefono(123456);
		contact.setIdContacto(1);
		
		//Se pasa el objeto contact a la lista tipo Contact...List<Contact>
		servicio.setDataInput(contact);
		
		//Se compara si el objeto ingresado manualmente, es igual al que registra la lista 
		//internamente mediante los métodos implementados
		assertEquals(contact, servicio.getDataInput().get(0));
	}
	
	@Test
	public void testEliminarContactoEnLista() {
		
		//Contacto agregado N°1
		contact.setNombre("Reinaldo");
		contact.setApellidoP("Barriga");
		contact.setApellidoM("Bauden");
		contact.setDireccion("Prueba 123");
		contact.setTelefono(123456);
		servicio.setDataInput(contact);
		
		// Contacto agregado N°2
		contact.setNombre("Prueba");
		contact.setApellidoP("Eliminar");
		contact.setApellidoM("Contacto");
		contact.setDireccion("Prueba Borrar");
		contact.setTelefono(111111);
		servicio.setDataInput(contact);
		
		//Se borra contacto N°2 y se compara el largo de la lista con 1.
		
		servicio.deleteDataInput(2);
		assertEquals(1,servicio.getDataInput().size());
	}
}
