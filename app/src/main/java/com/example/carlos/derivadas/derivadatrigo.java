package com.example.carlos.derivadas;

public class derivadatrigo extends Letras {
    public int numero,potencia,res1,res2,res3,res4;
    public String cos_sen;

    public derivadatrigo(int numero, String cos_sen, int potencia){
        this.numero=numero;
        this.cos_sen=cos_sen;
        this.potencia=potencia;
    }
    public String operacion(){
        if (this.cos_sen=="cos")
        {
            res1=this.numero*this.potencia;
            res2=this.potencia-1;
            if (res2==0)
            {
                return  "-"+res1+" sen "+this.numero+"x"+superscript(String.valueOf(this.potencia))+")";
            }
            return  "-"+res1+"x"+superscript(String.valueOf(res2))+" sen "+this.numero+"x"+superscript(String.valueOf(this.potencia));

        }
        else if (this.cos_sen=="sen")
        {
            res1=this.numero*this.potencia;
            res2=this.potencia-1;
            return res1+"x"+superscript(String.valueOf(res2))+" cos "+this.numero+"x"+superscript(String.valueOf(this.potencia));
        }
        else if (this.cos_sen=="tan")
        {
            res1=this.numero*this.potencia;
            res2=this.potencia-1;
            if (res2==0)
            {
                return res1+" sec² "+this.numero+"x"+superscript(String.valueOf(this.potencia));
            }
            return res1+"x"+superscript(String.valueOf(res2))+" sec² "+this.numero+"x"+superscript(String.valueOf(this.potencia));
        }
        else if (this.cos_sen=="arc sen")
        {
            res1=this.numero*this.potencia;
            res2=this.potencia-1;
            res3=this.numero*this.numero;
            res4=this.potencia*2;
            return res1+"x"+superscript(String.valueOf(res2))+" \u00F7 "+"\u221A1-"+res3+"x"+superscript(String.valueOf(res4));
        }
        else if (this.cos_sen=="arc cos")
        {
            res1=this.numero*this.potencia;
            res2=this.potencia-1;
            res3=this.numero*this.numero;
            res4=this.potencia*2;
            return "-"+res1+"x"+superscript(String.valueOf(res2))+" \u00F7 "+"\u221A1-"+res3+"x"+superscript(String.valueOf(res4));
        }
        else if (this.cos_sen=="arc tan")
        {
            res1=this.numero*this.potencia;
            res2=this.potencia-1;
            res3=this.numero*this.numero;
            res4=this.potencia*2;
            return res1+"x"+superscript(String.valueOf(res2))+" \u00F7 "+res3+"x"+superscript(String.valueOf(res4))+"+1";
        }
        else
        {
            return "";
        }
    }
}
