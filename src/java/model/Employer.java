/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import etu1912.framework.annoter.AnnotationUrl;
/**
 *
 * @author ITU
 */
public class Employer {
    String nom;
    String prenom;
    String fonction;

    public Employer(String nom, String prenom, String fonction) {
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
    }
    @AnnotationUrl(url = "ajout-emp")
    public void ajouterEmployer() {
        System.out.println("Bien envoyer");
    }
}
