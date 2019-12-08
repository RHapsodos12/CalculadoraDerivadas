package com.example.carlos.derivadas;

public class Derivada extends Letras {

    public int coeficiente,potencia;
    public int xc,xp;

    public Derivada(int coeficiente, int potencia)
    {
        this.coeficiente=coeficiente;
        this.potencia=potencia;
    }
    public String operacion()
    {
        xc=this.coeficiente*this.potencia;
        xp=this.potencia-1;
        return xc+"x"+superscript(String.valueOf(xp));
    }
}
