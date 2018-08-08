package com.diego.simulacion.controller;

import java.lang.Math;

public class EcuacionTercerGrado{
	public double A, B, C, D;
	
	public EcuacionTercerGrado(double A, double B, double C, double D){
		this.A = A;
		this.B = B;
		this.C = C;
		this.D = D;
	}
	
	public double evaluar(double x){
		return (A*Math.pow(x, 3))+(B*Math.pow(x,2))+(C*x)+D;
	}
	
	public double evaluarDerivada(double x){
		return ((3*A)*Math.pow(x,2))+((2*B)*x)+C;
	}
	
	public double evaluarIntegral(double x){
		return ((A/4)*Math.pow(x, 4))+((B/3)*Math.pow(x,3))+((C/2)*Math.pow(x,2))+(D*x);
	}
	
	public double integralDefinida(double a, double b){
		return evaluarIntegral(b)-evaluarIntegral(a);
	}
	
	public double getA(){return A;}
	public double getB(){return B;}
	public double getC(){return C;}
	public double getD(){return D;}
}