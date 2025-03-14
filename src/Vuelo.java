import java.util.Random;

/**
 * Clase Vuelo abstracta. Tiene 2 Clases hijas. Nacional e Internacional
 */
public abstract class Vuelo {
    /**
     * Arrays estàticos y protegidos con nombres de Aerolíneas y lugares para utilizar aleatoriamente en un constructor vacío.
     */
    protected static String[] aerolineas = {"Iberia", "Emirates", "QatarAir", "Aerolineas Argentinas", "TokyoAir", "VirginAirlines", "JuancitoAir"};
    protected static String[] lugares = {"Espana", "Argentina", "Portugal", "Francia", "Alemania", "Reino Unido", "China", "Japon", "Filipinas", "Polonia", "Emiratos Arabes"};


    /**
     * Atributo privado de tipo int de identificador de vuelo
     */
    private int identificador;
    /**
     * Atributo privado de tipo String de Nombre de la aerolínea
     */
    private String nombreAerolinea;
    /**
     * Atributo privado de tipo String de lugar de origen
     */
    private String origen;
    /**
     * Atributo privado de tipo String de lugar de destino
     */
    private String destino;
    /**
     * Atributo privado de tipo fecha de la fecha del vuelo
     */
    private Fecha fecha;
    /**
     * Atributo privado de tipo int de la cantidad de pasajeros
     */
    private int pasajeros;
    /**
     * Atributo privado de tipo double del precio del vuelo
     */
    protected double precio;


    /**
     * Constructor de vuelo con parámetros de entrada.
     * @param identificador Tipo int. identificador del vuelo
     * @param nombreAerolinea Tipo String. Nombre de la aerolinea
     * @param origen Tipo String. Lugar de origen del vuelo
     * @param destino Tipo String. Lugar de destino del vuelo
     * @param fecha Tipo Fecha. Fecha de vuelo
     * @param pasajeros Tipo Int. Cantidad de pasajeros
     * @param precio Tipo Double. Precio del vuelo
     */
    public Vuelo(int identificador, String nombreAerolinea, String origen, String destino, Fecha fecha, int pasajeros, double precio){
        this.identificador = identificador;
        this.nombreAerolinea = nombreAerolinea;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.pasajeros = pasajeros;
        this.precio = precio;
    }

    /**
     * Constructor vacío de vuelo que utiliza los arrays estáticos de la clase y un objeto de tipo Random para generar vuelos con parámetros aleatorios.
     */
    public Vuelo(){
        Random rd = new Random();
        identificador = rd.nextInt(1,2000);
        nombreAerolinea = aerolineas[rd.nextInt(aerolineas.length)];
        origen = lugares[rd.nextInt(lugares.length)];
        destino = lugares[rd.nextInt(lugares.length)];
        fecha = new Fecha();
        pasajeros = rd.nextInt(70,200);
        precio = (double) Math.round(rd.nextDouble(300.00, 600.00) * 100) / 100;
    }


    /**
     * Getter para el Identificador del vuelo
     * @return identificador. Tipo Int
     */
    public int getIdentificador(){
        return identificador;
    }
    /**
     * Getter para el Nombre de la aerolinea encarada del vuelo
     * @return nombreAerolinea. Tipo String
     */
    public String getNombreAerolinea(){
        return nombreAerolinea;
    }
    /**
     * Getter para el lugar de origen del vuelo
     * @return origen. Tipo String
     */
    public String getOrigen(){
        return origen;
    }
    /**
     * Getter para el lugar de destino del vuelo
     * @return destino. Tipo String
     */
    public String getDestino(){
        return destino;
    }
    /**
     * Getter para la fecha del vuelo
     * @return fecha. Tipo Fecha
     */
    public Fecha getFecha(){
        return fecha;
    }
    /**
     * Getter para la cantidad de pasajeros del vuelo
     * @return pasajeros. Tipo int
     */
    public int getPasajeros(){
        return pasajeros;
    }

    /**
     * Getter abstracto para el precio. Necesitará crearse una instancia hija del vuelo para poder calcularlo
     * @return precio. Tipo double
     */
    public abstract double getPrecio();


    //setters

    /**
     * Setter para el numero de identificacion del vuelo.
     * @param identificador Tipo int. Se establecerá este numero como nuevo identificador del vuelo.
     */
    public void setIdentificador(int identificador){
        this.identificador = identificador;
    }

    /**
     * Setter para el nombre de la aerolinea del vuelo.
     * @param aerolinea Tipo String. Se establecerá esta como nueva aerolinea encargada del vuelo.
     */
    public void setAerolinea(String aerolinea){
        this.nombreAerolinea = aerolinea;
    }

    /**
     * Setter para el origen del vuelo.
     * @param origen Tipo String. Se establecerá este como el nuevo origen del vuelo.
     */
    public void setOrigen(String origen){
        this.origen = origen;
    }

    /**
     * Setter del destino.
     * @param destino tipo String. Se establecerá este como el nuevo origen del vuelo.
     */
    public void setDestino(String destino){
        this.destino = destino;
    }

    /**
     * Setter para la fecha del vuelo
     * @param fecha tipo Fecha. Se establecerá esta como la nueva fecha del vuelo
     */

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * Setter para los pasajeros
     * @param pasajeros tipo Int. Se establecerá este como el nuevo numero de pasajeros.
     */

    public void setPasajeros(int pasajeros){
        this.pasajeros = pasajeros;
    }

    /**
     * Setter para el precio
     * @param precio tipo double. Se establecerá este como el nuevo precio para el vuelo
     */

    public void setPrecio(double precio){
        this.precio = precio;
    }

    /**
     * Metodo toString. Escribe los atributos del vuelo
     * @return Tipo String Devuelve un texto excrito con las características del vuelo
     */
    @Override
    public String toString(){
        return "\nID: " + getIdentificador() +
                "\nAerolinea: " + getNombreAerolinea() +
                "\nOrigen: " + getOrigen() +
                "\nDestino: " + getDestino() +
                "\nFecha: "+ getFecha() +
                "\nPasajeros: " + getPasajeros() +
                "\nPrecio: " + getPrecio();
    }
}
