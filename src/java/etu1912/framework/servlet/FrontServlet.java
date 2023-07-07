/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1912.framework.servlet;

import model.Login;
import com.google.gson.Gson;
import etu1912.framework.Mapping;
import etu1912.framework.ModelView;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
import etu1912.framework.annoter.AnnotationPrivilege;
import etu1912.framework.annoter.AnnotationSingle;
import etu1912.framework.annoter.AnnotationUrl;
>>>>>>> Stashed changes
=======
import etu1912.framework.annoter.AnnotationPrivilege;
import etu1912.framework.annoter.AnnotationSingle;
import etu1912.framework.annoter.AnnotationUrl;
>>>>>>> Stashed changes
import etu1912.framework.fonction.Utilitaire;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.*;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
import java.util.Vector;
import model.Employer;
import java.lang.Class;
import javax.servlet.http.HttpSession;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

/**
 *
 * @author ITU
 */
public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> MappingUrls = new HashMap<>();
    HashMap<String,Object> singleton = new HashMap<>();
    HashMap<String,Object> privilege = new HashMap();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
   
    public  void init() {
        Utilitaire u = new Utilitaire();
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = path.replaceAll("%20", " ");
        Vector<String> paks = u.getNomPackages(null,path,null);
        Vector<Class> cla = u.getClassViaPackage(paks,path);
        addSingleton(cla, singleton);
        u.allMapping(MappingUrls);
    }
    
    public void addSingleton(Vector<Class> cla, HashMap<String,Object> single){
        for(int i=0; i < cla.size(); i++)
        {
            if(cla.get(i).getAnnotation(AnnotationSingle.class)!=null){
                single.put(cla.get(i).getSimpleName(), null);
            }
        }
    }
    public Object verificationSingleton(Class nomClass, HashMap<String,Object> single){
        Object o = null;
        for(HashMap.Entry<String, Object>entry : single.entrySet()){
            try{
                if(entry.getKey().equals(nomClass.getSimpleName()) && entry.getValue()==null){
                    o = nomClass.newInstance();
                    entry.setValue(o);
                }else{
                    o = entry.getValue();
                }
                }catch(Exception e){
                e.printStackTrace();
            }
        }
        return o;
    }
    public String setName(String str){
        return "set" + str.substring(0,1).toUpperCase()+str.substring(1);
    }
    public Object castage(String parametre, String type){
        Object o = null;
        if(type.equals("int") || type.equals("Integer")){
            o = parseInt(parametre);
        }else if(type.equals("double")){
            o = parseDouble(parametre);
        }else{
            o = parametre;
        }
        return o;
    }
    
    public void getValeurFromUser(HttpServletRequest request, Object o){
        try{
            Field[] attribut = o.getClass().getDeclaredFields();
            for(Field f : attribut){
                String valeur = request.getParameter(f.getName());
                String type = f.getType().getSimpleName();
                Object ob = castage(valeur, type);
                System.out.println("type io : "+type);
                if(valeur!=null){
                    String setter = setName(f.getName());
                    
                    //Method met1 = o.getClass().getMethod(setter,String.class);
                    //met.invoke(o, valeur);
                    if(ob instanceof Integer){
                        Method met = o.getClass().getMethod(setter,int.class);
                        Integer nombre = Integer.valueOf(String.valueOf(ob));
                        met.invoke(o, nombre);
                    }else{
                        Method met = o.getClass().getMethod(setter,String.class);
                        String l = String.valueOf(ob);
                        met.invoke(o, l);
                    }
                    //System.out.println("yes yes : " +setter+" okay : "+met.getName()+" valeur "+valeur);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
                
                request.setAttribute("soratra",MappingUrls);
=======
               
                /*Employer e = new Employer();
                e.setNom("Rija");*/
>>>>>>> Stashed changes
=======
               
                /*Employer e = new Employer();
                e.setNom("Rija");*/
>>>>>>> Stashed changes
                String redirection = null; 
                try{
                    String[] url = new Utilitaire().getUrlEnCours(request.getRequestURI());
                    System.out.println("url io : "+request.getRequestURI());
                    String slug = url[url.length - 1];
                    if(url.length==2){
                        RequestDispatcher dispat = request.getRequestDispatcher("/Affichage/index.jsp"); 
                        dispat.forward(request,response);
                    }
                    if(MappingUrls.containsKey(slug)){
                        Mapping map = MappingUrls.get(slug);
                        Class clas = Class.forName(map.getCla());
<<<<<<< Updated upstream
<<<<<<< Updated upstream
                //Class clas = Employer.class;
                        Method fonction = clas.getDeclaredMethod(map.getMethod());
                //fonction.setAccessible(false);
                        ModelView page = (ModelView) fonction.invoke(clas.newInstance());
                        redirection = page.getView();
                    }
                    RequestDispatcher dispat = request.getRequestDispatcher("/Affichage/"+redirection); 
                    dispat.forward(request,response);
=======
                        Object o = verificationSingleton(clas,singleton);
                        
                        try{
=======
                        Object o = verificationSingleton(clas,singleton);
                        
                        /*try{
>>>>>>> Stashed changes
                            Object ooj = verificationSingleton(clas,singleton);
                            System.out.println("okayokay : "+ooj.getClass().getName());
                        }catch(Exception e){
                        e.printStackTrace();
<<<<<<< Updated upstream
                        }
                        
                        
                        for(HashMap.Entry<String, Object>entry : singleton.entrySet()){
                            System.out.println("lacles : "+entry.getKey()+" valeurs : "+entry.getValue().getClass().getName());
                        }
=======
                        }*/
                        
                        
                        /*for(HashMap.Entry<String, Object>entry : singleton.entrySet()){
                            System.out.println("lacles : "+entry.getKey()+" valeurs : "+entry.getValue().getClass().getName());
                        }*/
>>>>>>> Stashed changes
                        getValeurFromUser(request, o);
                        request.setAttribute("detail",o);
                        //Class clas = Employer.class;
                        System.out.println("classement : " +clas.getName());
                        Method fonction = clas.getDeclaredMethod(map.getMethod());
                        System.out.println("anarany le fonction : "+fonction.getName());
                        //fonction.setAccessible(false);
                        ModelView page = new ModelView();
<<<<<<< Updated upstream
                        page = (ModelView) fonction.invoke(o);
                        redirection = page.getView();
                        RequestDispatcher dispat = request.getRequestDispatcher("/Affichage/"+redirection); 
                        dispat.forward(request,response);
                        /*HttpSession session = request.getSession();
=======
                        //page = (ModelView) fonction.invoke(o);
                        
                        HttpSession session = request.getSession();
>>>>>>> Stashed changes
                        System.out.println("valeur : "+session.getAttribute("admin"));
                        System.out.println("valeur1 : "+fonction.getAnnotation(AnnotationUrl.class).url());
                        //page = (ModelView) fonction.invoke(o);
                        if(session.getAttribute("admin")==null){
                            page = (ModelView) fonction.invoke(o);
                            redirection = page.getView();
                            RequestDispatcher dispat = request.getRequestDispatcher("/Affichage/"+redirection); 
                            dispat.forward(request,response);
                        }
                        Boolean valeur = (Boolean) session.getAttribute("admin");
                        if(fonction.getAnnotation(AnnotationUrl.class).url().equals("admin") && valeur==true){
                            
                            page = (ModelView) fonction.invoke(o);
                            System.out.println(page.isIsJson());
                            if(page.isIsJson()) {
                                Gson gson = new Gson();
                                String json = gson.toJson(page.getListe());
                                PrintWriter out = response.getWriter();
                                out.print("TO JSON >>> " + json);
                                System.out.println("ts azo atao annnnnn11111");
                            }else{
                                redirection = page.getView();
                                RequestDispatcher dispat = request.getRequestDispatcher("/Affichage/"+redirection); 
                                dispat.forward(request,response);
                            }
                        }else{
                            System.out.println("ts azo atao annnnnn");
                        }
                        
                        HashMap<String,Boolean> vr = page.getAdmin();
                        for(HashMap.Entry<String, Boolean>entry : vr.entrySet()){
                            session.setAttribute(entry.getKey(),entry.getValue());
                            System.out.println("Ts admin ianao : "+entry.getKey()+entry.getValue());
<<<<<<< Updated upstream
                        }*/
=======
                        }
>>>>>>> Stashed changes
                        /*if(page.isIsJson()) {
                                Gson gson = new Gson();
                                String json = gson.toJson(page.getListe());
                                PrintWriter out = response.getWriter();
                                out.print("TO JSON >>> " + json);
                                System.out.println("ts azo atao annnnnn11111");
                            }*/
                        
                        /*}else{
                            System.out.println("Ts admin ianao");
                        }*/
                        
                        /*HttpSession session = request.getSession();
                        HashMap<String,Boolean> ad = page.getAdmin();
                        Login log = new Login();
                        log.setUser("Rindra");
                        log.setMdp("1234");
                        for(HashMap.Entry<String, Boolean>entry : ad.entrySet()){
                            request.setAttribute(entry.getKey(),entry.getValue());
                        }*/
                        
                        System.out.println("redirection :"+redirection);
                        HashMap<String,Object> l = page.getListe();
                        for(HashMap.Entry<String, Object>entry : l.entrySet()){
                            request.setAttribute(entry.getKey(),entry.getValue());
                        }
                        
                    }
                    
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
        }catch(Exception e){
            e.printStackTrace();
        }
                
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
