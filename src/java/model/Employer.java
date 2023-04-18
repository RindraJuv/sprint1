/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import etu1912.framework.ModelView;
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

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getFonction() {
        return fonction;
    }
    
    public Employer[] getInfoEmp(){
        Employer[] emp = new Employer[4];
        emp[0] = new Employer("Rakoto","Franck","Secretaire");
        emp[1] = new Employer("Rabe","Jean","Admin");
        emp[2] = new Employer("Will","Smith","Acteur");
        emp[3] = new Employer("Steve","Ocam","Comedien");
        return emp;
    }
    public Employer() {
    }
    @AnnotationUrl(url = "ajout-emp")
    public ModelView ajouterEmployer() {
        ModelView view = new ModelView("main.jsp");
        Employer[] e = this.getInfoEmp();
        view.executeHash("information", e);
        return view;
    }
}
