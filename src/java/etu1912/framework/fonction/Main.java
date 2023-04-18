/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1912.framework.fonction;
import etu1912.framework.Mapping;
import etu1912.framework.ModelView;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;
import model.Employer;


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
      
        try{
            String slug = "ajout-emp";
            
            if(mappingUrls.containsKey(slug)){
                Mapping map = mappingUrls.get(slug);
                Class<?> clas = Class.forName(map.getCla());
                //Class clas = Employer.class;
                Method fonction = clas.getDeclaredMethod(map.getMethod());
                //fonction.setAccessible(false);
                ModelView page = (ModelView) fonction.invoke(clas.newInstance());
                System.out.println("okok : "+page.getView());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        /*for(HashMap.Entry<String, Mapping>entry : mappingUrls.entrySet()){
            try {
                        Class clas = Class.forName(entry.getValue().getCla());
                        
                        System.out.println("io ny valiny : "+clas.getSimpleName());
                       
        
                        String page = String.valueOf(clas.getDeclaredMethod("ajouterEmployer").invoke(clas));
                        System.out.println("okok : "+page);
                        //System.out.println(page.getView()); 
                    } catch (Exception ex) {
                       ex.printStackTrace();
                    }
        }*/
        
        /*for(int i=0;i<str.size();i++){
            System.out.println(str.get(i));
        }*/
        for(int i=0;i<cla.size();i++){
            System.out.println(cla.get(i).getSimpleName());
        }
    }
}
