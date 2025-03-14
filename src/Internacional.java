import java.util.Random;

public class Internacional  extends Vuelo{
    private int cantidadEscalas = 0;
    private StringBuilder lugarEscalas = new StringBuilder("No hay");


    public Internacional(int identificador, String nombreAerolinea, String origen, String destino, Fecha fecha, int pasajeros, double precio, int cantidadEscalas, String lugarEscalas) {
        super(identificador, nombreAerolinea, origen, destino, fecha, pasajeros, precio);
        this.cantidadEscalas = cantidadEscalas;
    }
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

    @Override
    public double getPrecio() {
        if (getFecha().getMes() == 7 || getFecha().getMes() == 8) precio = precio + (precio*0.25);
        if (cantidadEscalas == 0){
            precio = precio - (precio*0.20)* cantidadEscalas;
        }
        return precio;
    }

    public int getCantidadEscalas() {
        return cantidadEscalas;
    }

    public StringBuilder getLugarEscalas() {
        return lugarEscalas;
    }

    public void setCantidadEscalas(int cantidadEscalas) {
        this.cantidadEscalas = cantidadEscalas;
    }

    public void setLugarEscalas(StringBuilder lugarEscalas) {
        this.lugarEscalas = lugarEscalas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCantidad de escalas: " + cantidadEscalas + "\nLugar de las escalas: " + lugarEscalas;

    }


}
