/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog_tarea06_sainz_pardo_carlos;

/**
 *
 * @author Carlos Sainz-Pardo Ortiz
 * 
 * Clase Vehiculo: 
 *      Representa a un vehiculo por su matrícula, marca, modelo y color.
 * 
 */
public class Vehiculo {
    private String matricula, marca, modelo, color;
            
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Constructor Vacio
    * 
    */
    public Vehiculo(){
        this.matricula = "";
        this.marca = "";
        this.modelo = "";
        this.color = "";
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Constructor
    * @param matricula 
    * @param marca
    * @param modelo
    * @param color
    */
    public Vehiculo(String matricula, String marca, String modelo, String color){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Getter para la matricula
    * @return String matricula
    */
    public String getMatricula(){
        return this.matricula;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Getter para la marca
    * @return String marca
    */
    public String getMarca(){
        return this.marca;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Getter para el modelo
    * @return String modelo
    */
    public String getModelo(){
        return this.modelo;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Getter para el color
    * @return String color
    */
    public String getColor(){
        return this.color;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Setter para la matricula
    * @param String matricula
    */
    public void setMatricula(String maricula){
        this.matricula = matricula;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Setter para la marca
    * @param String marca
    */
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Setter para el modelo
    * @param String modelo
    */
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Setter para el color
    * @param String color
    */
    public void setColor(String color){
        this.color = color;
    }
    
    
    /**
    *
    * @author Carlos Sainz-Pardo Ortiz
    * 
    * Getter para el modelo
    * @return String modelo
    */
    @Override
    public String toString(){
        return (this.marca + " " + this.modelo + ", de color " + this.color +
                                    ", con matrícula " + this.matricula);
    }
}
