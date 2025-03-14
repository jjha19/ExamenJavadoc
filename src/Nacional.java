/**
 * Clase Nacional. Es hija de la clase Vuelo.
 */

public class Nacional extends Vuelo {

    /**
     * Constructor con parámetros que crea un vuelo internacional.
     * @param identificador tipo Int. Identificador del vuelo
     * @param nombreAerolinea tipo String. Nombre de la aerolinea que se encarga del vuelo.
     * @param origen tipo String. Lugar de origen del vuelo.
     * @param destino tipo String. Lugar de destino Final del vuelo.
     * @param fecha tipo Fecha. Fecha en la que va a tener lugar el vuelo.
     * @param pasajeros tipo int. Cantidad de gente volando.
     * @param precio tipo double. Precio del vuelo.
     */
    public Nacional(int identificador, String nombreAerolinea, String origen, String destino, Fecha fecha, int pasajeros, double precio) {
        super(identificador, nombreAerolinea, origen, destino, fecha, pasajeros, precio);
    }

    /**
     * Constructor sin parámetros que utiliza el constructor sin parámetros -el que se llena aleatoriamente- de la clase
     * padre, pero iguala el pais de destino al pais de origen para hacerlo un vuelo Nacional.
     */
    public Nacional(){
        super();
        setDestino(getOrigen());
    }

    /**
     * Sobrescripcion del metodo abstracto de la clase padre, en el cual al precio base se le aplica un aumento
     * de 25% si es en Julio y del 30% si es en Agosto.
     * @return tipo Double. Precio final del vuelo con aumentos(si los hay).
     */

    @Override
    public double getPrecio() {
        if (getFecha().getMes() == 7)precio = precio + (precio*0.2);
        else if (getFecha().getMes() == 8)precio = precio + (precio*0.3);
        return precio;
    }

    /**
     * Utilizacion heredada del metodo toString de la clase padre.
     * @return tipo String. Una descripcion del vuelo.
     */
    @Override
    public String toString() {
        return super.toString();
    }

}
