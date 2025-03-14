import java.util.Random;

public class Fecha {
    int dia;
    int mes;
    int ano;

    public Fecha(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Fecha(){
        Random rd = new Random();
        dia = rd.nextInt(1,30);
        mes = rd.nextInt(1,12);
        ano = rd.nextInt(2021,2025);
    }
    //getters
    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }


    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
