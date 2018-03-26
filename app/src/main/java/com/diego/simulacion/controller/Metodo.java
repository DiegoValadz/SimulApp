package com.diego.simulacion.controller;

public class Metodo {
	int semilla;
	int multiplicador;
	int constante;
	int modulo;
	int iteracion;
	int[] array;
	
	public Metodo(int s, int m, int c, int md, int i){
		this.semilla = s;
		this.multiplicador = m;
		this.constante = c;
		this.modulo = md;
		this.iteracion = i;
        array = new int[iteracion];
	}
}