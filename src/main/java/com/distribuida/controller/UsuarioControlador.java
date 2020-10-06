package com.distribuida.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import com.distribuida.dto.Usuario;
import com.distribuida.proxy.UsuarioProxyImpl;



@Named(value= "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject	private UsuarioProxyImpl usuarioServicio;
	
	private List<Usuario> lista;
	private Usuario usuario;
	
	

	
	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
/*
	
	public void eliminarUsuario(Integer id) {
		
		usuarioServicio.deleteUsuario(id);
		
	}

	public void crearUsuario() {
		usuarioServicio.create(usuario);
		lista = usuarioServicio.findall();
		usuario = new Usuario ();
	}
	
	public String editarUsuario(Usuario usuario) {
	
		usuarioServicio.editar(usuario);
		usuario = new Usuario ();
		return "user-list?faces/redirect=true";
	}
	
	public String buscarUsuario(Integer id) {
		usuarioServicio.buscarUsuario(id);
		return "user-form?faces/redirect=true";
		
	}*/
	public String redireccionPersona() {
		lista = usuarioServicio.obtenerPersonas();
		return "persona?faces-redirect=true";
	}
	
	public String eliminarPersona(Integer id) {
		usuarioServicio.eliminarPersona(id);
		lista = usuarioServicio.obtenerPersonas();
		return "persona?faces-redirect=true";
	}
	
	public String crearPersona() {
		usuarioServicio.crear(usuario);
		lista = usuarioServicio.obtenerPersonas();
		return "persona?faces-redirect=true";
	}
	
	public String redireccionEditar(Usuario persEdit) {
		usuario = persEdit;
		return "editarPersona?faces-redirect=true";
	}
	
	public String editar() {
		 
		usuarioServicio.editar(usuario);
		return "persona?faces-redirect=true";
	}
	
}
