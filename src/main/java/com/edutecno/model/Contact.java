package com.edutecno.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Contact {
	
	private int idContacto;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private String direccion;
	private int telefono;

}
