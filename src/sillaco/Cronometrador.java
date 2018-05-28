/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Arturo Blanco
 */
public class Cronometrador extends Thread{
    private int Contador;
    private FabricaFrame fabrica;
    private Semaphore SEC;
    private int K;

    public Cronometrador(int K,int Contador, Semaphore SEC, FabricaFrame fabrica) {
        this.Contador = Contador;
        this.SEC = SEC;
        this.fabrica = fabrica;
        this.K = K;
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
        while(true){
            try {
                this.fabrica.getLblCronometrador().setText("Durmiendo");
                this.sleep(875);
                this.fabrica.getLblCronometrador().setText("Despierto");
                
                SEC.acquire(1);
                    this.sleep(125);
                    cronometrar();
                SEC.release(1);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometrador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cronometrar(){
        if (getContador() != 0){
            setContador(getContador()-1);
        }else{
            setContador(50);
            K=1;
        }
        this.fabrica.getLblContador().setText(Integer.toString(getContador()));
    }
}
