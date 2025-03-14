import java.util.Random;

/**
 * Clase fecha que permite crear objetos de tipo fecha para sy uso en los vuelos
 */
public class Fecha {
    /**
     * Atributos privados de dia, mes y año.
     */
    private int dia;
    private int mes;
    private int ano;

    /**
     * Constructor de Fecha con parámetros.
     * @param dia Tipo entero. Día del vuelo (dd)
     * @param mes Tipo entero. Mes del vuelo (mm)
     * @param ano Tipo entero. Año del vuelo (aaaa)
     */
    public Fecha(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * Constructor de Fecha sin parámetros que genera, utilizando un objeto tipo Random,
     * valores aleatorios posibles para cada atributo.
     * Dia 1-30.
     * Mes 1-12.
     * Año 2021-2025
     */

    public Fecha(){
        Random rd = new Random();
        dia = rd.nextInt(1,30);
        mes = rd.nextInt(1,12);
        ano = rd.nextInt(2021,2025);
    }

    /**
     * Getter para el día del vuelo
     * @return Tipo int. Día del vuelo
     */
    //getters

    public int getDia(){
        return dia;
    }

    /**
     * Getter para el mes del vuelo
     * @return Tipo int. Mes del vuelo
     */

    public int getMes(){
        return mes;
    }

    /**
     * Getter para el año del vuelo
     * @return Tipo int. año del vuelo
     */

    public int getAno(){
        return ano;
    }

    /**
     * Metodo toString. Escribe la fecha en formato dd/mm/aaaa
     * @return tipo String. Una fecha.
     */
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
}
