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
public class SillaCo {

    // Frames
    private static FabricaFrame Fabrica = new FabricaFrame();
    
    public static void main(String[] args) {
        Fabrica.setVisible(true);
        Fabrica.setDefaultCloseOperation(Fabrica.EXIT_ON_CLOSE);
    }
    
}
