/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progAvUD.parcialPrimerCorte.control;

/**
 *
 * @author Andres Felipe
 */
public class ControlPrincipal {
    
    private ControlGato controlGato;
    private ControlGrafico controlGrafico;

    public ControlPrincipal() {
        this.controlGato = new ControlGato(this);
        this.controlGrafico = new ControlGrafico(this);
        
    }
    
    
    
}
