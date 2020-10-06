package com.distribuida.proxyproducer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.distribuida.proxy.UsuarioProxy;

@ApplicationScoped
public class ProxyPersonaProducer {
	
	private static final String URL_SINGER = "https://chalacan-distribuida2.herokuapp.com";
	
	@Produces
	@ApplicationScoped
	public UsuarioProxy getProxy() {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(URL_SINGER));
		UsuarioProxy proxy = target.proxy(UsuarioProxy.class);
		return proxy;
	}
	
}
