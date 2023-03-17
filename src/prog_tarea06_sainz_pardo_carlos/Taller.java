/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_tarea06_sainz_pardo_carlos;

/**
 *
 * @author Carlos Sainz-Pardo Ortiz
 * 
 * Clase Taller: 
 *      Representa un taller con un array de vehículos y otro de reparaciones, así como
 *      los métodos para añadir/eliminar vehiculos/reparaciones.
 * 
 */
public class Taller {
    final private Vehiculo VEHICULO_VACIO;  // Para inicializar array de vehiculos en vacío y para usarlo al eliminar un vehiculo.
    private Object[][] vehiculos; // Array de objetos Object que contendrá en cada fila el Vehiculo y las reparaciones
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Constructor
    * 
    */
    public Taller(){
        this.VEHICULO_VACIO = new Vehiculo();
        this.vehiculos = new Object[5][4];
        for (int i = 0; i < this.vehiculos.length; i++) {
            this.vehiculos[i][0] = VEHICULO_VACIO; // Columna 0 con Vehiculos
            for (int j = 1; j < this.vehiculos[i].length; j++) {
                this.vehiculos[i][j] = ""; // Resto de columnas con reparaciones
            }
        }
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Método que añade un vehículo a la lista.
    * Se debe comprobar previamente que la lista no está llena
    * @param vehiculo un vehiculo válido
    */
    public void añadirVehiculo(Vehiculo vehiculo){
        if(this.getCantidadVehiculos() < 5)
            this.vehiculos[getCantidadVehiculos()][0] = vehiculo;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Método que elimina un vehículo de la lista.
    * @param matricula la matrícula de un vehiculo válido
    * @return Si se ha conseguido eliminar o no
    */
    public boolean eliminarVehiculo(String matricula){
        boolean resultado = false;
        int posicion = this.getPosicionVehiculo(matricula);
        if(posicion!=-1){
            for(int i=posicion;i<this.vehiculos.length-1;i++){  // Movemos todos una posición
                for(int j=0;j<this.vehiculos[i].length;j++){
                    this.vehiculos[i][j] = this.vehiculos[i+1][j];
                }
            }
            // Reseteamos la última linea del array
            this.vehiculos[4][0] = VEHICULO_VACIO; 
            for(int j=1;j<this.vehiculos[4].length;j++){
               this.vehiculos[4][j] = "";
            }
            resultado = true;
        }
        // Devolvemos el resultado
        return resultado;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Método que busca un vehículo en la lista y devuelve su posición en ella.
    * @param matricula la matricula de un vehiculo válido
    * @return posicion en la lista ó -1 si no está.
    */
    public int getPosicionVehiculo(String matricula){
        int posicion = -1;
        for(int i=0;i<this.vehiculos.length;i++){
            if(!this.vehiculos[i][0].equals(VEHICULO_VACIO)){
                Vehiculo vehiculo = (Vehiculo) this.vehiculos[i][0];
                if(vehiculo.getMatricula().equals(matricula)){
                    posicion = i;
                }
            }
        }
        return posicion;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Método que devuelve el vehículo que está en la posición pasada por parámetro
    * @param posicion la posición del vehiculo en la lista
    * @return el vehículo en cuestión.
    */
    public Vehiculo getVehiculoEnPosicion(int posicion){
        return (Vehiculo) this.vehiculos[posicion][0];
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Método que añade una reparación a la lista.
    * @param matricula la matricula del vehiculo
    * @param reparacion la descripción de la reparación.
    */
    public void añadirReparacion(String matricula, String reparacion, int posicion){
        this.vehiculos[getPosicionVehiculo(matricula)][posicion] = reparacion;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Método que lista las reparaciones de un vehículo
    * @param matricula la matrícula de un vehiculo válido
    * 
    */
    public void verReparaciones(String matricula){
        int cantidadReparaciones = 0;
        int posicion = this.getPosicionVehiculo(matricula);
        if(posicion==-1){
            System.out.println("\nError, el vehículo no está en la lista.\n");
        } else {
            for (int i=1;i<this.vehiculos[posicion].length;i++) {
                if (this.vehiculos[posicion][i] != "") {
                    cantidadReparaciones++;
                }
            }
            if(cantidadReparaciones==0) {
                System.out.println("Este vehículo no tiene ninguna reparación asignada.");
            } else {
                System.out.println(cantidadReparaciones + " reparaciones:\n");
                for(int i=1;i<=cantidadReparaciones;i++){
                    System.out.println(i + ".-   " + this.vehiculos[posicion][i]);
                }
            }
        }
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Getter para la cantidad de vehiculos que existen en el taller
    * @return int Cantidad de vehiculos en el array.
    */
    public int getCantidadVehiculos(){
        int contador=0;
        for (int i=0;i<this.vehiculos.length;i++) {
            if (!this.vehiculos[i][0].equals(VEHICULO_VACIO)) {
                contador++;
            }
        }
        return contador;
    }
    
    public int getCantidadReparaciones(String matricula){
        int contador=0;
        int posicion = getPosicionVehiculo(matricula);
        for (int i=0;i<this.vehiculos[posicion].length;i++) {
            if (!this.vehiculos[posicion][i].equals("")) {
                contador++;
            }
        }
        return contador;
    }
}