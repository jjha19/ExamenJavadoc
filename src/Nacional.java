public class Nacional extends Vuelo {

    public Nacional(int identificador, String nombreAerolinea, String origen, String destino, Fecha fecha, int pasajeros, double precio) {
        super(identificador, nombreAerolinea, origen, destino, fecha, pasajeros, precio);
    }
    public Nacional(){
        super();
        setDestino(getOrigen());
    }

    @Override
    public double getPrecio() {
        if (getFecha().getMes() == 7)precio = precio + (precio*0.2);
        else if (getFecha().getMes() == 8)precio = precio + (precio*0.3);
        return precio;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
