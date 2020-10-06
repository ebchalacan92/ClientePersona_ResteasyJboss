package com.distribuida.proxy;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.distribuida.dto.Usuario;



@ApplicationScoped
public class UsuarioProxyImpl{

	
	@Inject private UsuarioProxy proxy;

	public List<Usuario> obtenerPersonas(){
		return proxy.findall();
	}
	
	public Usuario buscarPorId(Integer id) {
		return proxy.buscar(id);
	}
	
	public void eliminarPersona(Integer id) {
		proxy.delete(id);
	}
	
	public Usuario crear(Usuario p) {
		return proxy.crear(p);
	}
	
	public Usuario editar(Usuario p) {
		return proxy.editar(p);
	}
}
