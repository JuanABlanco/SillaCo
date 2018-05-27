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
public class Cronometrador extends Thread{
    private int Contador=0;
    private FabricaFrame fabrica;
    private Semaphore SEC;

    public Cronometrador(int Contador, Semaphore SEC, FabricaFrame fabrica) {
        this.Contador = Contador;
        this.SEC = SEC;
        this.fabrica = fabrica;
    }
    // Setters y Getters
    
    public FabricaFrame getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaFrame fabrica) {    
        this.fabrica = fabrica;
    }

    public int getContador() {
        return Contador;
    }

    public void setContador(int Contador) {
        this.Contador = Contador;
    }

    public Semaphore getSEC() {
        return SEC;
    }

    public void setSEC(Semaphore SEC) {
        this.SEC = SEC;
    }
    
    //
    // Metodos
    @Override
    public void run(){
        
    }
    
    public void cronometrar(){
        if (getContador() != 0){
            
        }else{
            
        }
    }
}
