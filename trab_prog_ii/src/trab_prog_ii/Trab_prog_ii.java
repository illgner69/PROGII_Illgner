/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_prog_ii;

/**
 *
 * @author Illgner
 */
public class Trab_prog_ii {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfaceGUI painel = new InterfaceGUI();
        painel.pack();
        painel.setSize(920, 680);
        painel.setLocationRelativeTo(null);
        painel.setResizable(false);
        painel.setVisible(true);
        painel.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
}
