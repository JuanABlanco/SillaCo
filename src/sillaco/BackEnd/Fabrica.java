/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco.BackEnd;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Juan Arturo Blanco
 */
public class Fabrica {
    //Almacenes
    private int AlmacenS [];
    private int AlmacenP [];      
    private int AlmacenA [];
    //Constantes
    private int Contador;
    private int K;
    //Semaforos del Almacen de Patas y sus apuntadores 
    private Semaphore SEP;
    private Semaphore SPP;
    private Semaphore SCP;
    private int InP;
    private int OutP;
    //Semaforos del Almacen de Asientos y sus apuntadores 
    private Semaphore SEA;
    private Semaphore SPA;
    private Semaphore SCA;
    private int InA;
    private int OutA;
    //Semaforos del Almacen de Sillas y sus apuntadores 
    private Semaphore SES;
    private Semaphore SPS;
    private int InS;
    private int OutS;
    //Semaforo de 
    private Semaphore SEC;
    //Arreglos de Productores y Ensambladores
    private PAsientos PA [];
    private PPatas PP [];
    private Ensamblador Ensam [];
    // Otros trabajadores
    private Cronometrador Crono;
    private Gerente Geren;
    
    
}
