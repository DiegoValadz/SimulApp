package com.diego.simulacion.controller;

public class Mixto extends Metodo {
	public Mixto(int s, int m, int c, int md, int i){
		super(s, m, c, md, i);
	}
	
	private void generarNumeros(){
		int x = semilla;
		
		for(int i=0; i<iteracion; i++){
			x = ((multiplicador * x) + constante) % modulo;
			array[i] = x;
		}
		
	}
	
	public int[] toArray(){
		generarNumeros();
		return array;
	}
	
	public String toString(){
		String x ="";
		generarNumeros();
		for(int i=0; i<iteracion; i++){
			x += array[i] + ", ";
		}
		return x;
	}
	public int getI(){
		return iteracion;
	}
}