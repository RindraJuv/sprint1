/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1912.framework.fonction;
import etu1912.framework.Mapping;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.Class;
import java.util.Vector;
import etu1912.framework.annoter.AnnotationUrl;
import java.util.HashMap;
/**
 *
 * @author ITU
 */
public class Utilitaire {
    public Utilitaire(){
        
    }
    public String getAllPath(String str){
        String[] spliteur = str.split("/");
        String[] spliteur1 = spliteur[2].split(".");
        return spliteur1[0];
    }
    
    public Vector<String> getNomPackages(Vector<String> packages, String path, String c){
        String concat = ".";
        if(packages == null)
            packages = new Vector<>();
        if(c == null) {
            c = "";
            concat = "";
        }
        File dossier = new File(path);
        File[] files = dossier.listFiles();
        for (File file : files) {
            if(file.isDirectory()) {
           
                packages.add(c + concat + file.getName());
                //System.out.println(debut + concat + file.getName());
                packages = getNomPackages(packages, file.getPath(), c + concat + file.getName());
            }
        }
        return packages;
    }
    
    public Vector<Class> getClassViaPackage(Vector<String> nomPack){
        Vector<Class> liste = new Vector<Class>(); 
        String path = "C:\\Users\\ITU\\Documents\\NetBeansProjects\\Sprint1\\build\\web\\WEB-INF\\classes\\";
        try{
                
                for(int x=2;x<nomPack.size();x++){
                    File paquet = new File(path + nomPack.get(x).replace('.', '\\'));
		    File[] allClasses = paquet.listFiles();
                    for(int i=0;i<allClasses.length;i++){
                        if(allClasses[i].getName()!=null){
                        String nomClass = nomPack.get(x) + "." + allClasses[i].getName().split(".class")[0];
                        //System.out.println(allClasses[i].getName());
                        Class cl = Class.forName(nomClass);
                        liste.add(cl);
                        }
                    }
                }
		}catch(Exception e){
			e.printStackTrace();
		}
       return liste;
    }
    public void addMapping(HashMap<String, Mapping> mappingUrls, Vector<Class> cla){
        for(int i=0; i<cla.size(); i++){
            Method[] met = cla.get(i).getDeclaredMethods();
            for(int a=0;a<met.length;a++){
                if(met[a].getAnnotation(AnnotationUrl.class)!=null){
                    Mapping mapping = new Mapping(cla.get(i).getName(), met[a].getName());
                    /*System.out.println("class : " + cla.get(i).getName() + " method : " +met[a].getName());
                    System.out.println("url : " + met[a].getAnnotation(AnnotationUrl.class).url());
                    System.out.println(mapping.getCla());
                    System.out.println(mapping.getMethod());*/
                    mappingUrls.put(met[a].getAnnotation(AnnotationUrl.class).url(), mapping);
                }
            }
        }
        
    }
     public void allMapping(HashMap<String, Mapping> mappingUrls){
         String path = "C:\\Users\\ITU\\Documents\\NetBeansProjects\\Sprint1\\build\\web\\WEB-INF\\classes";
         Vector<String> paks = this.getNomPackages(null,path,null);
         Vector<Class> cla = this.getClassViaPackage(paks);
         addMapping(mappingUrls,cla);
     }
     public String[] getUrlEnCours(String str){
         String[] resultat = str.split("/");
         return resultat;
     }
    
}
