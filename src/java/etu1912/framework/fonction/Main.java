/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1912.framework.fonction;
import etu1912.framework.Mapping;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author ITU
 */
public class Main {
    public static void main(String[] args){
        Utilitaire u = new Utilitaire();
        HashMap<String, Mapping> mappingUrls = new HashMap<>();
        
        String path = "C:\\Users\\ITU\\Documents\\NetBeansProjects\\Sprint1\\build\\web\\WEB-INF\\classes";
        Vector<String> str = u.getNomPackages(null,path,null);
        Vector<Class> cla = u.getClassViaPackage(str);
        u.allMapping(mappingUrls);
        for(HashMap.Entry<String, Mapping>entry : mappingUrls.entrySet()){
            System.out.println("okok " +entry.getKey() +" valeur " +entry.getValue().getCla() +" method "+entry.getValue().getMethod());
        }
        /*for(int i=0;i<str.size();i++){
            System.out.println(str.get(i));
        }*/
        for(int i=0;i<cla.size();i++){
            System.out.println(cla.get(i).getSimpleName());
        }
    }
}
