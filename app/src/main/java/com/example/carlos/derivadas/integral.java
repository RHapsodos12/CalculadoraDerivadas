package com.example.carlos.derivadas;

import org.nfunk.jep.JEP;

public class integral {
    JEP jet;

    public double calculateIntegral ( String a1, String b1, String n1, String function ) {
        double base = 0;
        double a = 0;
        double b = 0;
        double h = 0;
        int n = 0;


        try {
            System.out.println(function);
            // se implementa la libreria JEP para la manpulacion de ecuaciones
            jet = new JEP();
            jet.addStandardFunctions();
            jet.addStandardConstants();
            jet.setImplicitMul(true);
            jet.parseExpression(a1);
            // se obtienen el valor de a1 y se guarda en a
            a = jet.getValue();

            jet.parseExpression(b1);
            // se obtiene el valor de b1 y se guarda en b
            b = jet.getValue();

            // se obtiene el valor n1 y se guarda en n convertida a entero
            n = Integer.parseInt(n1);
            // se calcula el valor de h
            h = (double) ((b - a) / n);
            // se crea el vector y se obtiene el valor que le corresponde a cada
            // valor de x
            double x[] = new double[n + 1];
            x[0] = a;
            x[n] = b;

            for (int i = 1; i < x.length - 1; i++) {
                x[i] = (double) (x[0] + (i * h));

            }
            // se crea el vextor de la funcion donde se almacena la la funcion
            // con cada valor de x
            double fx[] = new double[n + 1];
            for (int i = 0; i < n + 1; i++) {
                if ((i == 0) || (i == n)) {
                    fx[i] = jet.addVariable("x", x[i]);
                    jet.parseExpression(function);
                    fx[i] = jet.getValue();
                    // Sumatoria de la funcion calculada por el valor de x
                    base += (double) fx[i];

                } else {
                    fx[i] = jet.addVariable("x", x[i]);
                    jet.parseExpression(function);
                    fx[i] = 2 * jet.getValue();
                    // Sumatoria de la funcion calculada por el valor de x
                    base += (double) fx[i];

                }

            }

        } catch (Exception e) {
            // System.out.println(e.getLocalizedMessage() + function);
        }
        // retorna el valor del area aproximada
        return (double) (base * h) / 2;
    }
}
