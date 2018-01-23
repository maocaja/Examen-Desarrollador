package com.mcajamarca.callcenter.modelo;

public final class Operador extends Empleado {
	
	
	protected Empleado proximo;
	
	public Operador(String nombre ,boolean estado) {
		this.nombre = nombre;
		this.libre = estado;
	}
	
	@Override
	public void setProximo(Empleado proximo) {
		this.proximo = proximo;
	}

	@Override
	public Empleado getProximo() {
		return proximo;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void contestarLLamada(Llamada llamada) {
		
		if(this.libre){
			System.out.println("El Operador atiende la llamada "+ this.getNombre());
			this.setLibre(false);
			llamada.setAtendida(true);
		}else if (this.proximo != null){
			this.proximo.contestarLLamada(llamada);
		}else{
			System.out.println("Todos nuestros operadores se encuentran ocupados");
		}
	}

}
