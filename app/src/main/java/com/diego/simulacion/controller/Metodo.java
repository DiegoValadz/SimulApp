package com.diego.simulacion.controller;

public class Metodo {
	public int semilla;
	public int multiplicador;
	public int constante;
	public int modulo;
	public int iteracion;
	public int[] array;
	
	public Metodo(int s, int m, int c, int md, int i){
		this.semilla = s;
		this.multiplicador = m;
		this.constante = c;
		this.modulo = md;
		this.iteracion = i;
        array = new int[iteracion];
	}
}