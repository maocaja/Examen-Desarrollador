package com.mcajamarca.callcenter.modelo;


public abstract class Empleado {
	
	protected boolean libre;
	protected String nombre;
	
	/*
	 * Método que asigna un manejador como sucesor de la peticion
	 * */
	public abstract void setProximo(Empleado proximo);

	/*
	 * Método que obtiene el sucesor de la peticón
	 * */ 
	public abstract Empleado getProximo();
	
	/*
	 * Método que se encarga de procesar la solicitud según los criterios establecidos
	 * */
	
	public abstract void contestarLLamada (Llamada llamada);
}
