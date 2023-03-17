/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog_tarea06_sainz_pardo_carlos;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Carlos Sainz-Pardo Ortiz
 * 
 * Clase Principal
 * Aplicación para gestionar un taller. TAREA PROG06.
 * 
 * @version 1.1 Corregidos comentarios del profesor
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String matricula, marca, modelo, color;
        Taller taller = new Taller(); // Objeto Taller
        
        boolean salir = false;
        while(!salir){
            byte opcion = menuPrincipal(); // Uso byte porque no es necesario usar más memoria
            
            switch(opcion){
               
                case 0:
                    System.out.println("\n\nHa elegido SALIR. Que tenga un buen día...");
                    salir = true;
                    break;
                   
                case 1:
                    System.out.println("\nHa elegido la opción Nuevo Vehiculo.");
                    if(taller.getCantidadVehiculos() < 5) {
                        System.out.println("A continuación introduzca los datos del vehículo:\n");
                        Pattern pMatricula = Pattern.compile("[1-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}");
                        do{
                            matricula = solicitarDato("la matrícula").toUpperCase();
                            if(!pMatricula.matcher(matricula).matches()) System.out.println("\n ****  La matricula introducida no es válida.  ****\n"
                                                                                            + " ****   Debe tener 4 cifras y 3 consonantes.   ****\n"
                                                                                            + " ****      Ejemplos: 1234BCD ó 5678fgh.        ****\n");
                        } while(!pMatricula.matcher(matricula).matches());
                        if(taller.getPosicionVehiculo(matricula)==-1){  // Comprobamos que el vehículo no esté ya en la lista.
                            marca = solicitarDato("la marca").toUpperCase();
                            modelo =solicitarDato("el modelo").toUpperCase();
                            color = solicitarDato("el color").toUpperCase();
                            taller.añadirVehiculo(new Vehiculo(matricula, marca, modelo, color));
                            System.out.println("\nEl vehículo " + marca + " " + modelo + ", de color " + color +
                                    ", con matrícula " + matricula + " se ha añadido a la lista.\n");
                        } else {
                            System.out.println("\n ****  Ese vehículo ya está en la lista.  ****\n");
                        }
                    } else {
                        System.out.println("\n ****  La lista de vehículos está llena. Debe eliminar algún vehículo antes de añadir más.  ****\n");
                    }
                    break;
                           
                case 2:
                    System.out.println("\nHa elegido la opción Listado de Vehiculos.");
                    if(taller.getCantidadVehiculos()==0){
                        System.out.println("\n        No hay vehículos.");
                    } else {
                        for(int i=0;i<taller.getCantidadVehiculos();i++){
                            System.out.println("----------------------------------------------------------------\n");
                            System.out.println("Vehiculo " + (i+1) + ":");
                            Vehiculo vehiculoActual = taller.getVehiculoEnPosicion(i);
                            System.out.println(vehiculoActual.toString());
                            System.out.println("Reparaciones asignadas a este vehículo:");
                            System.out.println("----------------------------------------------------------------");
                            taller.verReparaciones(vehiculoActual.getMatricula());
                            System.out.println("----------------------------------------------------------------\n");
                        }
                        System.out.println("\n            FIN DEL LISTADO\n");
                    }
                    break;
                   
                case 3:
                    System.out.println("\nHa elegido la opción Buscar Vehiculo.");
                    Pattern pMatricula = Pattern.compile("[1-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}");
                    do{
                        matricula = solicitarDato("la matrícula").toUpperCase();
                        if(!pMatricula.matcher(matricula).matches()) System.out.println("\n ****  La matricula introducida no es válida.  ****\n");
                    } while(!pMatricula.matcher(matricula).matches());
                    int posicion = taller.getPosicionVehiculo(matricula);
                    if(posicion==-1){
                        System.out.println("\n ****  No existe ningún vehiculo en la lista con esa matricula.  ****\n");
                    } else {
                        Vehiculo vehiculoActual = taller.getVehiculoEnPosicion(posicion);
                        System.out.println(vehiculoActual.toString());
                    }
                    break;
                   
                case 4:
                    System.out.println("\nHa elegido la opción Nueva Reparación.");
                    pMatricula = Pattern.compile("[1-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}");
                    do{
                        matricula = solicitarDato("la matrícula").toUpperCase();
                        if(!pMatricula.matcher(matricula).matches()) System.out.println("\n ****  La matricula introducida no es válida.  ****\n");
                    } while(!pMatricula.matcher(matricula).matches());
                    if(taller.getPosicionVehiculo(matricula)==-1){
                        System.out.println("\n ****  No existe ningún vehiculo en la lista con esa matricula.  ****\n");
                    } else {
                        posicion = taller.getCantidadReparaciones(matricula);
                        if(posicion == 4){ // La lista está llena
                            System.out.println("\n ****  A este vehículo no se le pueden realizar mas reparaciones.  ****\n");
                        } else {
                            taller.añadirReparacion(matricula, solicitarDato("la descripción de la reparación"), posicion);
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("\nHa elegido la opción Listado de Reparaciones.");
                    pMatricula = Pattern.compile("[1-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}");
                    do{
                        matricula = solicitarDato("la matrícula").toUpperCase();
                        if(!pMatricula.matcher(matricula).matches()) System.out.println("\n ****  La matricula introducida no es válida.  ****\n");
                    } while(!pMatricula.matcher(matricula).matches());
                    if(taller.getPosicionVehiculo(matricula)==-1){
                        System.out.println("\n ****  No existe ningún vehiculo en la lista con esa matricula.  ****");
                    } else {
                        Vehiculo vehiculoActual = taller.getVehiculoEnPosicion(taller.getPosicionVehiculo(matricula));
                        System.out.println(vehiculoActual.toString());
                        System.out.println("\nReparaciones asignadas a este vehículo:");
                        System.out.println("----------------------------------------------------------------");
                        taller.verReparaciones(matricula);
                        System.out.println("----------------------------------------------------------------\n");
                    }
                    break;
                
                case 6:
                    System.out.println("\nHa elegido la opción Eliminar un Vehiculo.");
                    pMatricula = Pattern.compile("[1-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}");
                    do{
                        matricula = solicitarDato("la matrícula").toUpperCase();
                        if(!pMatricula.matcher(matricula).matches()) System.out.println("\n ****  La matricula introducida no es válida.  ****\n");
                    } while(!pMatricula.matcher(matricula).matches());
                    posicion = taller.getPosicionVehiculo(matricula);
                    if(posicion==-1){
                        System.out.println("\n ****  No existe ningún vehiculo en la lista con esa matricula.  ****\n");
                    } else {
                        String salida = taller.eliminarVehiculo(matricula)? "\nSe ha eliminado corretamente" : "\nSe ha producido algún error";
                        System.out.println(salida);
                    }
                    break;
            }
        }
    }
    
    /**
     *     
     *  @author Carlos Sainz-Pardo Ortiz
     * 
     *  Método que imprime el menú principal, solicita una operación, comprueba que sea válida y la devuelve
     *  @param scanner un objeto de tipo Scanner
     *  @return La opción seleccionada por el usuario
     * 
     */
    private static byte menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        byte opcion=-1;
        do{
            System.out.println("\n       MENU PRINCIPAL");
            System.out.println("----------------------------");
            System.out.println("   1 --- Nuevo Vehículo ");
            System.out.println("   2 --- Listado de Vehículos ");
            System.out.println("   3 --- Buscar Vehículo ");
            System.out.println("   4 --- Nueva Reparación ");
            System.out.println("   5 --- Listado de Reparaciones ");
            System.out.println("   6 --- Eliminar Vehiculo ");
            System.out.println("\n   0 --- Salir ");
            System.out.println("----------------------------");
            System.out.print("  Introduzca una opción: ");
            try{
                opcion = scanner.nextByte();
            } catch(InputMismatchException E) {
                scanner.next();
            }
            if(!((0<=opcion) && (opcion<=8))){
                System.out.println("\n\n----------------------------------------------------------------");
                System.out.println("|   Opción no válida, debe introducir un número entre 0 y 8.   |");
                System.out.println("----------------------------------------------------------------\n\n");
            } 
        } while(!((0<=opcion) && (opcion<=6))); // Debe estar entre esos valores
        return opcion;
    }
    
    /**
     *     
     *  @author Carlos Sainz-Pardo Ortiz
     * 
     *  Método que solicita un dato de tipo texto, comprueba que no sea cadena vacia, y lo devuelve
     *  @param scanner un objeto de tipo Scanner
     *         descripcion un string con la descripción del dato solicitado
     *  @return el texto introducido por el usuario
     * 
     */
    private static String solicitarDato(String descripcion){
        Scanner scanner = new Scanner(System.in);
        String texto = "";
        do{
            System.out.println("Introduzca " + descripcion + ": ");
            texto = scanner.nextLine();
            if(texto.equals("") || texto.isBlank()){ // Por si no introducen nada
                System.out.println("\n\n       No es válido, debe introducir algún dato en " + descripcion + ".\n\n");
                texto = "";
            }
        } while(texto.equals(""));
        return texto;
    }
}
