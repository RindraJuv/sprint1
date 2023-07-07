/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import etu1912.framework.ModelView;
import etu1912.framework.annoter.AnnotationUrl;
import etu1912.framework.annoter.AnnotationSingle;
/**
 *
 * @author ITU
 */
@AnnotationSingle(ref = "singleton")
public class Employer {
    int id;
    String nom;
    String prenom;
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public Employer(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public Employer(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

   

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    
    public Employer[] getInfoEmp(){
        Employer[] emp = new Employer[4];
        emp[0] = new Employer("Rakoto","Franck");
        emp[1] = new Employer("Rabe","Jean");
        emp[2] = new Employer("Will","Smith");
        emp[3] = new Employer("Steve","Ocam");
        return emp;
    }
    public Employer() {
    }

    public Employer() {
    }
    @AnnotationUrl(url = "ajout-emp")
    public ModelView ajouterEmployer() {
        ModelView view = new ModelView("main.jsp");
<<<<<<< Updated upstream
=======
        Employer[] e = this.getInfoEmp();
        view.executeHash("information", e);
       
>>>>>>> Stashed changes
        return view;
    }
}
