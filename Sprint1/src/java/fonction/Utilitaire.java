/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonction;

/**
 *
 * @author ITU
 */
public class Utilitaire {
    public Utilitaire(){
        
    }
    public String getAllPath(String str){
        String[] spliteur = str.split("/");
        String[] spliteur1 = spliteur[2].split("?");
        return spliteur1[0];
    }
}
