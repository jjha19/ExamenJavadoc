import java.util.Scanner;

/**
 * Clase Main (o Tester) que proporciona un menú que, utilizando un objeto Scanner, lee las opciones proporcionadas
 * por el usuario en entrada/salida.
 * Por defecto inicaliza un gestor de vuelos de tamaño 10 que se rellena con 8 vuelos (4 Nacionales, 4 Internacionales)
 * con atributos aleatorios.
 * En esta clase se pueden utilizar los metodos de la clase gestor para modificar, eliminar o añadir vuelos a gusto.
 */
public class Main {
    public static void main(String[] args) {
        GestionVuelos gestor = new GestionVuelos(10);
        Scanner sc = new Scanner(System.in);

        int opcion;
        System.out.println("Por defecto se ha creado un gestor de vuelos de tamaño 10 con 8 vuelos dentro ");
        do {
            System.out.println("Escribe qué quieres hacer con el gestor de vuelos" +
                    "\n 1 Crear un gestor de vuelos sobreescribiendo el anterior" +
                    "\n 2 Mostrar en consola el gestor de vuelos" +
                    "\n 3 Dar de baja un vuelo" +
                    "\n 4 Dar de alta un vuelo" +
                    "\n 5 Mostrar un listado de vuelos con origen, destino y precio establecidos" +
                    "\n 6 Modificar el precio base de un vuelo" +
                    "\n 7 Actualizar un vuelo internacional añadiendo escalas" +
                    "\n 8 Eliminar vuelos con origen y destino elegidos" +
                    "\n 9 Ordenar los vuelos por precio" +
                    "\n 10 Salir");
            opcion = sc.nextInt();
            sc.nextLine();
                switch (opcion){
                    case 1:
                        System.out.println("Elige la cantidad de vuelos que manejará el gestor");
                        int tamaño = sc.nextInt();
                        gestor = new GestionVuelos(tamaño);
                        System.out.println("Gestor de vuelos generado con exito");
                        break;
                    case 2:
                        gestor.mostrarEnConsola();
                        break;
                    case 3:
                        System.out.println("Escribe el id del vuelo a dar de baja");
                        int id = sc.nextInt();
                        if (gestor.darBaja(id)) {
                            System.out.println("Se ha eliminado exitosamente");
                        }else System.out.println("No se ha eliminado el vuelo");
                        break;
                    case 4:
                        if (gestor.hayHueco()){
                            boolean vuelopuesto = false;
                            for (int i = 0; i < gestor.getVuelos().length && !vuelopuesto; i++) {
                                if (gestor.getVuelos()[i] == null ){
                                    gestor.getVuelos()[i] = gestor.generarVuelo();
                                    vuelopuesto = true;
                                }
                            }
                        }else System.out.println("No hay sitio para otro vuelo");
                        break;
                    case 5:
                        System.out.println("Introduce el origen");
                        String origen = sc.nextLine();
                        System.out.println("Introduce el destino");
                        String destino = sc.nextLine();
                        System.out.println("Introduce el precio minimo");
                        double precioMin = sc.nextDouble();
                        System.out.println("Introduce el precio maximo");
                        double precioMax = sc.nextDouble();

                        System.out.println(gestor.listarVuelos(origen,destino,precioMin,precioMax));
                        break;
                    case 6:
                        gestor.modificarPrecio();
                        break;
                    case 7:
                        gestor.actualizarVuelo();
                        break;
                    case 8:
                        gestor.eliminarVuelo();
                        break;
                    case 9:
                        gestor.ordenarVuelos();
                        gestor.mostrarEnConsola();

                        break;
                }
        }while (opcion !=10);
    }
}