package com.diego.simulacion.models;

public class Resultados {
    private String tipo;
    private int f0;
    private double fe,fe2;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getF0() {
        return f0;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public double getFe2() {
        return fe2;
    }

    public void setFe2(double fe2) {
        this.fe2 = fe2;
    }

}
