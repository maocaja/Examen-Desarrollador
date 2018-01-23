package com.mcajamarca.callcenter.modelo;

public final class Supervisor extends Empleado{

	protected Empleado proximo;
	
	public Supervisor(String nombre, boolean estado) {
		this.nombre = nombre;
		this.libre = estado; 
	}
	
	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}
	
	@Override
	public void setProximo(Empleado proximo) {
		this.proximo = proximo;
	}

	@Override
	public Empleado getProximo() {
		return proximo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void contestarLLamada(Llamada llamada) {
		
		if(this.libre){
			System.out.println("El supervisor atiende la llamada " + this.getNombre());
			this.setLibre(false);
			llamada.setAtendida(true);
		} else if (this.proximo != null){
			this.proximo.contestarLLamada(llamada);
		}else{
			System.out.println("Todos nuestros operadores se encuentran ocupados");
		}
	}
}
