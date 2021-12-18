package models;

import utils.Almacen;

public class Usuario {
	private String nombre, passwd;

	// Const
	public Usuario(String nombre, String passwd) {
		this.nombre = nombre;
		this.passwd = passwd;
	}

	// Getters - Setters
	public String getNombre() {
		return nombre;
	}

	// Methods
	public boolean existe(String nombre) {
		for (Usuario registrado : Almacen.usuarios) {
			if (registrado.getNombre().equals(nombre))
				return true;
		}
		return false;
	}

	public boolean entrar(Usuario usuario) {
		for (Usuario registrado : Almacen.usuarios) {
			if (usuario.nombre.equals(registrado.nombre))
				if (usuario.passwd.equals(registrado.passwd))
					return true;
				else
					return false;
			else
				return false;
		}
		return false;
	}

	public boolean registrar(Usuario usuario) {
		if (existe(usuario.getNombre()))
			return false;
		else
			Almacen.usuarios.add(usuario);
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + "]";
	}

}
