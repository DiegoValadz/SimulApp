package com.diego.simulacion.models;

public class ResultadoMontecarlo{
	private double X, Y, R;
	
	public ResultadoMontecarlo(double X, double Y, double R){
		this.X = X;
		this.Y = Y;
		this.R = R;
	}
	
	public double getX(){return X;}
	public double getY(){return Y;}
	public double getR(){return R;}
}