import java.util.Scanner;

/**
 * Clase de Gestion de vuelos. Esta clase tiene un array de objetos tipo vuelo de un tamaño a determinar por el constructor
 */
public class GestionVuelos {
    //Encapsulao
    /**
     * Atributo privado de tipo Vuelo sobre el cual se va a actuar.
     */
    private Vuelo[] vuelos;

    /**
     * Getter para el array de vuelos.
     * @return Tipo Vuelo. Un array de vuelos
     */
    public Vuelo[] getVuelos() {
        return vuelos;
    }

    /**
     * Cosntructor del gestor de vuelos. Se debe determinar el tamaño que va a tener el array.
     * @param tamano Tipo Int. Tamaño del array de vuelos que gestionará.
     */
    public GestionVuelos(int tamano){
        vuelos = new Vuelo[tamano];
        for (int i = 1; i < vuelos.length - 1; i++) {
            if (i % 2 == 0) {
                vuelos[i] = new Nacional();
            } else vuelos[i] = new Internacional();
        }
    }

    /**
     * Este metodo muestra el
     */
    public  void mostrarEnConsola() {
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] != null){
                System.out.println(vuelos[i].toString());
            }
        }
    }

    public boolean darBaja(int id){
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        int opcion = 0;
        boolean eliminado = false;
        for (int i = 0; i < vuelos.length && !encontrado; i++) {
            if (vuelos[i] != null){
                if(vuelos[i].getIdentificador() == id){
                    encontrado = true;
                    System.out.println("Se ha encontrado el vuelo " + vuelos[i].toString() + "\n Seguro quieres eliminarlo? 1.Si 2.No");
                    opcion = sc.nextInt();
                    sc.nextLine();
                    if (opcion == 1) {
                        vuelos[i] = null;
                        eliminado = true;
                    }
                }
            }
        }
        if (!encontrado) {System.out.println("No se ha encontrado el vuelo con ese ID");}
        return eliminado;
    }

    public boolean hayHueco(){
        boolean vacio = false;
        for (int i = 0; i < vuelos.length && !vacio; i++) {
            if (vuelos[i] == null){
                vacio = true;
            }
        }
        return vacio;
    }

    public Vuelo generarVuelo(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        Vuelo vuelo = null;
        do {
            System.out.println("Que tipo de vuelo quieres hacer? 1.Nacional 2.Internacional");
            opcion = sc.nextInt();
        }while (opcion != 1 && opcion != 2);

        System.out.println("Que identificador va a tener?");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Qué aerolinea lo lleva a cabo?");
        String aerolinea = sc.nextLine();

        System.out.println("Que origen tiene?");
        String origen = sc.nextLine();

        System.out.println("Hacia donde va?");
        String destino = sc.nextLine();

        System.out.println("Cuándo es? Escribelo en formato 'dd mm aaaa'. Ve presionando enter a medida que lo colocas");
        int dd = sc.nextInt();
        sc.nextLine();
        int mm = sc.nextInt();
        sc.nextLine();
        int aaaa = sc.nextInt();
        sc.nextLine();
        Fecha fecha = new Fecha(dd,mm,aaaa);

        System.out.println("Cuantos pasasjeros viajan?");
        int pasajeros = sc.nextInt();
        sc.nextLine();
        System.out.println("Qué precio base va a tener?");
        double precio = sc.nextDouble();
        sc.nextLine();
        if (opcion == 1){
            vuelo = new Nacional(id,aerolinea,origen,destino,fecha,pasajeros,precio);
        }else {
            int escalas;
            String lugaresEscalas = null;
            System.out.println("Cuantas escalas tendra?");
            escalas = sc.nextInt();
            sc.nextLine();
            if (escalas != 0){
                System.out.println("Donde las tendrá?");
                lugaresEscalas = sc.nextLine();
            }else lugaresEscalas = "No Hay";
            vuelo = new Internacional(id,aerolinea,origen,destino,fecha,pasajeros,precio,escalas,lugaresEscalas);
        }
        System.out.println("Vuelo generado exitosamente");
        return vuelo;
    }

    public StringBuilder listarVuelos(String origen, String destino, double precioMin, double precioMax){
        StringBuilder vuelosFiltrados = new StringBuilder();
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] != null){
                if(vuelos[i].getOrigen().equalsIgnoreCase(origen) && vuelos[i].getDestino().equalsIgnoreCase(destino) && (vuelos[i].getPrecio() > precioMin && vuelos[i].getPrecio()<precioMax)) {
                    vuelosFiltrados.append(vuelos[i].toString());
                }
            }
        }
        return vuelosFiltrados;
    }

    public void modificarPrecio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id del vuelo cuyo precio quieres modificar");
        int id = sc.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] != null){
                if (id == vuelos[i].getIdentificador()){
                    encontrado =true;
                    System.out.println("Introduce el nuevo precio que quieres que tenga");
                    vuelos[i].setPrecio(sc.nextDouble());
                    System.out.println("Se ha modificado el precio con exito");
                }
            }
        }
        if (!encontrado) System.out.println("No se encotró un vuelo con ese ID");
    }

    public void actualizarVuelo () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el id del vuelo");
        int id = sc.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < vuelos.length && !encontrado; i++) {
            if (vuelos[i] != null){
                if (id == vuelos[i].getIdentificador()) {
                    encontrado = true;
                    if (vuelos[i] instanceof Internacional) {
                        Internacional vueloInter = (Internacional) vuelos[i];
                        System.out.println("Se ha encontrado el vuelo:\n" + vueloInter.toString());
                        System.out.println("Escribe cuántas escalas va a hacer");
                        int escalas = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Donde hará " + escalas + " escalas? Escribelo todo junto");
                        StringBuilder lugarEscalas = new StringBuilder(sc.nextLine());
                        vueloInter.setCantidadEscalas(escalas);
                        vueloInter.setLugarEscalas(lugarEscalas);
                    } else System.out.println("Ese vuelo no es internacional. No puede hacer escalas fuera del pais");
                }
            }
        }
        if (!encontrado) System.out.println("No se encotró un vuelo con ese ID");
    }


    public void eliminarVuelo(){
        Scanner sc = new Scanner(System.in);
        boolean encontrado = false;
        boolean eliminado = false;
        System.out.println("Escribe el origen de los vuelos que quieres eliminar");
        String origenElim = sc.nextLine();
        System.out.println("Escribe el destino de los vuelos que quieres eliminar");
        String destinoElim = sc.nextLine();

        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] != null){
                if (origenElim.equalsIgnoreCase(vuelos[i].getOrigen()) && destinoElim.equalsIgnoreCase(vuelos[i].getDestino())){
                    encontrado = true;
                    int eleccion;
                    System.out.println("Se ha encontrado el siguiente vuelo: " + vuelos[i].toString() + "\nSeguro quieres eliminarlo?\n 1.Si  cualquierOtroNumero.No");
                    eleccion = sc.nextInt();
                    if (eleccion == 1){
                        vuelos[i] = null;
                        eliminado = true;
                        System.out.println("Vuelo eliminado con exito");
                    }
                }
            }
        }
        if (!encontrado) System.out.println("No se encotrado un vuelo con esos parametros");
        if (!eliminado) System.out.println("No se ha eliminado ningun vuelo");

    }

    public void ordenarVuelos(){
        for (int i = 0; i < vuelos.length; i++) {
            if (vuelos[i] != null){
                for (int j = 0; j < vuelos.length; j++) {
                    if (vuelos[j] != null){
                        if (vuelos[i].getPrecio() > vuelos[j].getPrecio()){
                            Vuelo aux = vuelos[i];
                            vuelos[i] = vuelos[j];
                            vuelos[j] = aux;
                        }
                    }
                }
            }
        }
    }

}
