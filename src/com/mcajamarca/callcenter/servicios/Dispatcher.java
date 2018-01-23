package com.mcajamarca.callcenter.servicios;

import java.util.List;

import com.mcajamarca.callcenter.modelo.Empleado;
import com.mcajamarca.callcenter.modelo.Llamada;

public final class Dispatcher{
	
	private List<Empleado> listaEmpleados;
	private List<Llamada> listaLlamadas;
	
	public Dispatcher(List<Empleado> listaEmpleados,List<Llamada> listaLlamadas) {
		this.listaEmpleados = listaEmpleados;
		this.listaLlamadas = listaLlamadas;
		crearCadenaEmpleados();
	}
	
	private void crearCadenaEmpleados(){
		for(int i = 0 ; i < listaEmpleados.size()-1; i ++){			
			listaEmpleados.get(i).setProximo(listaEmpleados.get(i + 1));
		}
	}
	
	public void dispatchCall() {
		Empleado empleado = listaEmpleados.get(0);
		for (Llamada llamada : listaLlamadas) {
			if (empleado != null){
				System.out.println(llamada.getMensaje());
				empleado.contestarLLamada(llamada);
				empleado = empleado.getProximo();
			}else{
				System.out.println("Todos asesores se encuetran ocupados");
			}
			
		}
    }
}
