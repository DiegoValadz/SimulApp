package com.diego.simulacion.controller;

public class Multiplicativo {
	int semilla;
	int multiplicador;
	int constante;
	int modulo;
	int iteracion;
	static int p[] = {3, 11, 13, 19, 21, 27, 29, 37, 53, 59, 61, 67, 69, 77, 83, 91};
	int[] array;
	
	public Multiplicativo(int s, int t, int p, int c, int md, int i){
		this.semilla = s;
		this.multiplicador = (200*t)+p;
		this.constante = c;
		this.modulo = md;
		this.iteracion = i;
        array = new int[iteracion];
	}
	
	private void generarNumeros(){
		int x = semilla;
		for(int i=0; i<iteracion; i++){
			x = ((multiplicador*x)+constante)%modulo;
			array[i] = x;
		}
	}

	public void setMultiplicador(int p){
		this.multiplicador = multiplicador+p;
	}
	
	public int[] toArray(){
		generarNumeros();
		return array;
	}
	
	public String toString(){
		String x = "";
		generarNumeros();
		for(int i=0; i<iteracion; i++){
			x += array[i] + ", ";
		}
		return x;
	}
}