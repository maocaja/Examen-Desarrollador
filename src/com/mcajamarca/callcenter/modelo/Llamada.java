package com.mcajamarca.callcenter.modelo;

import java.util.Random;

public final class Llamada {
	
	private String id;
	private int duracion;
	private String mensaje;
	private boolean atendida;
	private static final Integer DURACION_MAXIMA = 10000;
	private static final Integer DURACION_MINIMA = 5000;
	
	public Llamada(String id,String mensaje){
		if (id == null){
			throw new AssertionError("El id de la llamada no puede ser null");
		}
		
		this.id = id;
		this.duracion = new Random().nextInt((DURACION_MAXIMA - DURACION_MINIMA) + 1) + DURACION_MINIMA;
		this.atendida = false;
		this.mensaje = mensaje;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isAtendida() {
		return atendida;
	}

	public void setAtendida(boolean atendida) {
		this.atendida = atendida;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
