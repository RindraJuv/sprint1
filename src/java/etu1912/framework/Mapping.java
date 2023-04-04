/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1912.framework;

/**
 *
 * @author ITU
 */
public class Mapping {
    String className;
    String Methode;

    public Mapping(String className, String Methode) {
        this.className = className;
        this.Methode = Methode;
    }
    public String getCla(){
        return this.className;
    }
    public String getMethod(){
        return this.Methode;
    }
    
    
}
