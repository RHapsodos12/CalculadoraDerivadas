package com.example.carlos.derivadas;

public class DerivadaIndefinida extends Letras {
    public int coeficiente,potencia,res1;

    public DerivadaIndefinida(int coeficiente, int potencia) {
        this.coeficiente = coeficiente;
        this.potencia = potencia;
    }

    public String operarIntegral()
    {
        res1=potencia+1;
        return coeficiente+"x"+superscript(String.valueOf(res1))+" \n── + C\n "+res1;
    }
}
