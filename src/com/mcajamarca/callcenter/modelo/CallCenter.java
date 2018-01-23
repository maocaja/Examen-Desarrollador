package com.mcajamarca.callcenter.modelo;

import java.util.ArrayList;
import java.util.List;

import com.mcajamarca.callcenter.servicios.Dispatcher;

public class CallCenter {
	
	private List<Empleado> listaEmpleados;
	private List<Llamada> listaLlamadas;
	private Dispatcher dispacher;
	private int operadores;
	private int supervisores;
	private int directores;
	private int llamadas;
	
	public CallCenter(int operadores, int supervisores, int directores, int llamadas) {
		this.operadores = operadores;
		this.supervisores = supervisores;
		this.directores = directores;
		this.llamadas = llamadas;
		llenarListaEmpleados();
		llenarListaLlamadas();
	}
	
	public int getOperadores() {
		return operadores;
	}

	public int getSupervisores() {
		return supervisores;
	}

	public int getDirectores() {
		return directores;
	}

	public int getLlamadas() {
		return llamadas;
	}
	
	private void llenarListaEmpleados(){
		
		listaEmpleados = new ArrayList<Empleado>();
		
		for(int i = 1 ; i <= this.operadores; i ++){			
			listaEmpleados.add(new Operador("Operador " + i, true));
		}
		
		for(int i = 1 ; i <= this.supervisores; i ++){			
			listaEmpleados.add(new Supervisor("Supervisor " + i,true));
		}
		
		for(int i = 1 ; i <= this.directores; i ++){			
			listaEmpleados.add(new Director("Director " + i,true));
		}
	}
	
	private void llenarListaLlamadas(){
		listaLlamadas = new ArrayList<Llamada>();
		for(int i = 1 ; i <= this.llamadas; i ++){			
			listaLlamadas.add(new Llamada(""+ i,"Llamada " + i));
		}
	}
	
	public void atenderLlamadas(){
		dispacher = new Dispatcher(listaEmpleados,listaLlamadas);
		dispacher.dispatchCall();
	}
	
	public static void main(String[] args) {
		/*
		 * Escenario 1, donde hay 2 operadores, un supervisor y un director con 5 llamadas.
		 */
		CallCenter callCenter = new CallCenter(2,1,1,5);
		callCenter.atenderLlamadas();
		
		
		/*
		 * Escenario 2, donde hay 2 operadores, un supervisor y un director con 6 llamadas.
		 */
		CallCenter callCenter2 = new CallCenter(2,1,1,6);
		callCenter2.atenderLlamadas();
		
		
	}
}
