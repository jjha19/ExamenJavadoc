import java.util.Random;

/**
 * Clase Internacional. Es hija de la clase abstracta Vuelo. En ella están dos atributos que se
 * le añaden.
 */
public class Internacional  extends Vuelo{

    /**
     * Los atributos privados Cantidad de escalas y lugar Escalas son de tipo string int
     * y StringBuilder respectivamente y hacen referencia a las escalas que hace un vuelo internacional.
     */
    private int cantidadEscalas;
    private StringBuilder lugarEscalas = new StringBuilder("No hay");

    /**
     * Constructor con parámetros que crea un vuelo internacional.
     * @param identificador tipo Int. Identificador del vuelo
     * @param nombreAerolinea tipo String. Nombre de la aerolinea que se encarga del vuelo.
     * @param origen tipo String. Lugar de origen del vuelo.
     * @param destino tipo String. Lugar de destino Final del vuelo.
     * @param fecha tipo Fecha. Fecha en la que va a tener lugar el vuelo.
     * @param pasajeros tipo int. Cantidad de gente volando.
     * @param precio tipo double. Precio del vuelo.
     * @param cantidadEscalas tipo int. Cantidad de escalas que hará el vuelo.
     * @param lugarEscalas tipo String. Lugares donde el vuelo hará las escalas.
     */
    public Internacional(int identificador, String nombreAerolinea, String origen, String destino, Fecha fecha, int pasajeros, double precio, int cantidadEscalas, StringBuilder lugarEscalas) {
        super(identificador, nombreAerolinea, origen, destino, fecha, pasajeros, precio);
        this.cantidadEscalas = cantidadEscalas;
        this.lugarEscalas = lugarEscalas;
    }

    /**
     * Constructor sin parámetros que, haciendo uso de un objeto tipo Random y los arrays de String estàticos
     * de la clase padre (nombresAerolineas[], lugares[]), generará los valores necesarios
     * para dar de alta un vuelo válido
     */
    public Internacional(){
        super();
        Random rd = new Random();
        cantidadEscalas  = rd.nextInt(0,5);
        if (cantidadEscalas !=0 ){
            lugarEscalas.setLength(0);
            for (int i = 0; i < cantidadEscalas ; i++) {
                lugarEscalas = lugarEscalas.append(lugares[rd.nextInt(lugares.length)]).append(" ");
            }
        }
    }

    /**
     * Sobrescripcion del metodo abstracto de la clase padre, en el cual al precio base se le aplica un aumento
     * de 25% si es en Julio o Agosto, y un descuento del 20% por cada escala que tenga
     * @return tipo Double. Precio final del vuelo. Con aumentos y/o descuentos.
     */
    @Override
    public double getPrecio() {
        if (getFecha().getMes() == 7 || getFecha().getMes() == 8) precio = precio + (precio*0.25);
        if (cantidadEscalas == 0){
            precio = precio - (precio*0.20)* cantidadEscalas;
        }
        return precio;
    }

    /**
     * Getter de la cantidad de escalas que tiene el vuelo
     * @return tipo Int. Cantidad de escalas que tiene.
     */

    public int getCantidadEscalas() {
        return cantidadEscalas;
    }

    /**
     * Getter del lugar de las escalas.
     * @return tipo StringBuilder. Los lugares de escala que tiene el vuelo Internacional.
     * Si no hay escalas devolverá "No hay"
     */

    public StringBuilder getLugarEscalas() {
        return lugarEscalas;
    }

    /**
     * Setter de la cantidad de escalas.
     * @param cantidadEscalas Tipo int. La cantidad de escalas que pasará a tener el vuelo.
     */
    public void setCantidadEscalas(int cantidadEscalas) {
        this.cantidadEscalas = cantidadEscalas;
    }

    /**
     * Setter del lugar (o los lugares) de las escalas del vuelo internacional.
     * @param lugarEscalas tipo StringBuilder. Lugar/es de las escalas que pasará a tener el vuelo.
     */
    public void setLugarEscalas(StringBuilder lugarEscalas) {
        this.lugarEscalas = lugarEscalas;
    }

    /**
     * Sobrescripcion del metodo toString de la clase padre añadiendo detrás los atributos de la clase Internacional.
     * @return tipo String. La descripción del vuelo internacional.
     */

    @Override
    public String toString() {
        return super.toString() + "\nCantidad de escalas: " + cantidadEscalas + "\nLugar de las escalas: " + lugarEscalas;

    }


}
