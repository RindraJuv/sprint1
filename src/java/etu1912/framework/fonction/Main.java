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
        /*Vector<String> str = u.getNomPackages(null,path,null);
        Vector<Class> cla = u.getClassViaPackage(str);
        u.allMapping(mappingUrls);
      
        try{
<<<<<<< Updated upstream
            String slug = "ajout-emp";
=======
           /* String slug = "ajout-emp";
>>>>>>> Stashed changes
            
            if(mappingUrls.containsKey(slug)){
                Mapping map = mappingUrls.get(slug);
                Class<?> clas = Class.forName(map.getCla());
                //Class clas = Employer.class;
                Method fonction = clas.getDeclaredMethod(map.getMethod());
                //fonction.setAccessible(false);
                ModelView page = (ModelView) fonction.invoke(clas.newInstance());
                System.out.println("okok : "+page.getView());
<<<<<<< Updated upstream
            }
        }catch(Exception e){
            e.printStackTrace();
        }
=======
            }*/
          /* Employer e = new Employer();
           ModelView mod = e.ajouterEmployer();
           Employer[] em = new Employer[4];
           HashMap<String,Object> l = mod.getListe();
           for(HashMap.Entry<String, Object>entry : l.entrySet()){
               em = (Employer[]) entry.getValue();
               System.out.println(em[0].getNom());
               System.out.println(entry.getKey());
           }
        }catch(Exception e){
            e.printStackTrace();
        }*/
>>>>>>> Stashed changes
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
        /*for(int i=0;i<cla.size();i++){
            System.out.println(cla.get(i).getSimpleName());
        }*/
    }
}
