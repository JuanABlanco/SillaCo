/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco;

import sillaco.FabricaFrame;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Juan Arturo Blanco
 */
public class SillaCo {
    //Almacenes
    static public int AlmacenS []= new int[100];
    static public int AlmacenP []= new int[50];    
    static public int AlmacenA []= new int[40]; 
    //Constantes
    static public int Contador=50;
    static public int K=1;
    //Semaforos del Almacen de Patas y sus apuntadores 
    static public Semaphore SEP= new Semaphore(1);
    static public Semaphore SPP= new Semaphore(AlmacenP.length);
    static public Semaphore SCP= new Semaphore(0);
    static public int InP=0;
    static public int OutP=0;
    //Semaforos del Almacen de Asientos y sus apuntadores 
    static public Semaphore SEA= new Semaphore(1);
    static public Semaphore SPA= new Semaphore(AlmacenA.length);
    static public Semaphore SCA= new Semaphore(0);
    static public int InA=0;
    static public int OutA=0;
    //Semaforos del Almacen de Sillas y sus apuntadores 
    static public Semaphore SES= new Semaphore(1);
    static public Semaphore SPS= new Semaphore(AlmacenS.length);
    static public int InS=0;
    static public int OutS=0;
    //Semaforo del contador
    static public Semaphore SEC= new Semaphore(1);
    //Arreglos de Productores y Ensambladores
    static public PAsientos PA []= new PAsientos[10];
    static public PPatas PP []= new PPatas[10];
    static public Ensamblador Ensam []= new Ensamblador[5];    
    // Frames
    public static FabricaFrame Fabrica = new FabricaFrame();
    // Otros trabajadores
    static public Cronometrador Crono = new Cronometrador(K,Contador,SEC,Fabrica);
    static public Gerente Geren = new Gerente(Fabrica,Contador, AlmacenS, K, SES,SPS,SEC,OutS,InS);

    
    public static void main(String[] args) {
        Fabrica.setVisible(true);
        Fabrica.setDefaultCloseOperation(Fabrica.EXIT_ON_CLOSE);
    }
    
}
