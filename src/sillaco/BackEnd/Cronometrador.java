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
    private int Contador;
    private Semaphore SEC;

    public Cronometrador(int Contador, Semaphore SEC) {
        this.Contador = Contador;
        this.SEC = SEC;
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
    
    public void Cronometrar(){
        
    }
}
