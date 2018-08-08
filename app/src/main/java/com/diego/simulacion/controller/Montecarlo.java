package com.diego.simulacion.controller;

import com.diego.simulacion.models.ResultadoMontecarlo;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Montecarlo{
	public EcuacionTercerGrado ec;
	public double min;
	public double max;
	public float cuenta;
	public List listaPuntosAleatorios;
	public Random rand;
	private char tipo;
	
	public static final char SENO = 's';
	public static final char E = 'e';
	
	/**
	*Constructor para ecuaciones algebraicas de hasta tercer grado
	*@param A coeficiente del termino de tercer grado
	*@param B coeficiente del termino de segundo grado
	*@param C coeficiente del termino de primer grado
	*@param D coeficiente del termino independiente
	*@param min valor desde el cual se va a evalual la integral
	*@param max valor hasta el cual se va a evaluar la integral
	*/
	public Montecarlo(double A, double B, double C, double D, double min, double max){
		this.ec = new EcuacionTercerGrado(A,B,C,D);
		this.min = min;
		this.max = max;
		this.cuenta = 0f;
		this.tipo = 'a';
		this.listaPuntosAleatorios = new ArrayList<>();
		this.rand = new Random();
		generarPuntos();
	}
	
	/**
	*Constructor para evaluar sen(x) o e^x
	*@param opt caracter que define cual de las dos ecuaciones se va a evaluar
	*@param min valor desde el cual se va a evaluar la integral
	*@param max valor hasta el cual se va a evaluar la integral
	*/
	public Montecarlo(final char opt, float min, double max){
		this.min = min;
		this.max = max;
		this.cuenta = 0f;
		this.listaPuntosAleatorios = new ArrayList<>();
		this.rand = new Random();
		switch(opt){
			case Montecarlo.SENO:
				this.tipo = 'b';
				generarPuntos();
				break;
			case Montecarlo.E:
				this.tipo= 'c';
				generarPuntos();
				break;
		}
	}
	
	/**
	*Genera una lista de numeros aleatorios en el rango en el que se va a evaluar la integral
	*/
	private void generarPuntos(){
		double[] X;
		double[] Y;
		double[] R;
		X = new double[1000];
		Y = new double[1000];
		R = new double[1000];
		
		
		for(int i=0; i<1000; i++){
			X[i] = (double)((rand.nextFloat()*(max-min))+min);
		}
		
		switch(tipo){
			case 'a':
				for(int i=0; i<1000; i++){
					Y[i] = (double)(rand.nextFloat()*ec.evaluar(max));
				}
				break;
			case 'b':
				for(int i=0; i<1000; i++){
					Y[i] = (double)rand.nextFloat();
				}
				break;
			case 'c':
				for(int i=0; i<1000; i++){
					Y[i] = (double)(rand.nextFloat()*Math.exp(max));
				}
				break;
		}
		
		switch(tipo){
			case 'a':
				for(int i=0; i<1000; i++){
					R[i] = (double)(ec.evaluar(X[i]));
				}
				break;
			case 'b':
				for(int i=0; i<1000; i++){
					R[i] = (double)(Math.sin(X[i]));
				}
				break;
			case 'c':
				for(int i=0; i<1000; i++){
					R[i] = (double)(Math.exp(X[i]));
				}
				break;
		}
		
		for(int i=0; i<1000; i++){
			listaPuntosAleatorios.add(new ResultadoMontecarlo(X[i], Y[i], R[i]));
		}
	}
	
	/**
	*Compara si el elemento en listaY es menor al elemento en listaFx, 
	*si lo es, aumenta el contador 'cuenta'
	*/
	private void comparar(int i){
		ResultadoMontecarlo res = (ResultadoMontecarlo) listaPuntosAleatorios.get(i);
		if(res.getY() < res.getR()) cuenta++;
	}
	
	/**
	*Calcula el area total en la que se van a evaluar los puntos
	*@return Area en la que se evaluan los puntos
	*/
	private double getArea(){
		double a=0;
		switch(tipo){
			case 'a': a=(max-min)*ec.evaluar(max); break;
			case 'b': a=(max-min); break;
			case 'c': a=(max-min)*Math.exp(max); break;
		}
		return a;
	}

	/**
	*Calcula el valor de la integral por el metodo de montecarlo
	*@param cant cantidad de puntos que va a evaluar el metodo
	*@return valor aproximado de la integral
	*/
	public float getResultado(int cant){
		cuenta=0f;
		for(int i=0; i<cant; i++){
			comparar(i);
		}
		return (float)getArea()*(cuenta/cant);
	}
	
	public List getListaResultados(){
		return new ArrayList(){{
			add(getResultado(100));
			add(getResultado(200));
			add(getResultado(500));
			add(getResultado(1000));
		}};
	}
	
	public List getListaPuntosAleatorios(){
		return listaPuntosAleatorios;
	}
	
	public static void main(String[] args){
		Montecarlo mc;
		List puntos, res;
		ResultadoMontecarlo r;
		
		//METODO getListaPuntosAleatorios() devuelve una lista de objetos tipo 'Resultado', cada objeto Resultado
		//tiene 3 atributos, X, Y y R
		
		//METODO getListaResultados() devuelve una lista con 4 numeros que son las aproximaciones usando el metodo montecarlo
		//usando 100, 200, 500 y 1000 puntos respectivamente
		
		
		//Integral de (x^2 + 1) de 0 a 1
		mc = new Montecarlo(0,1,0,1,0,1);
		puntos = mc.getListaPuntosAleatorios();
		res = mc.getListaResultados();
		//imprime resultados
		for(int i=0; i<4; i++){
			System.out.println(res.get(i));
		}
		//imprime 10 puntos aleatorios
		for(int i=0; i<10; i++){
			r = (ResultadoMontecarlo) puntos.get(i);
			System.out.println(r.getX()+", "+r.getY()+": "+r.getR());
		}
		
		//Integral de (x) de 0 a 1
		
		
		//Integral de (x^3 + 2) de 0 a 2
		
		
		//Integral de Sen(x) de 0 a PI
		
		
		//Integral de e^x de 1 a 2 
		
	}
}