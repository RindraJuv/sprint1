/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1912.framework.servlet;

import etu1912.framework.Mapping;
import etu1912.framework.ModelView;
import etu1912.framework.fonction.Utilitaire;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.*;

/**
 *
 * @author ITU
 */
public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> MappingUrls = new HashMap<>();
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
        u.allMapping(MappingUrls);
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
                
                request.setAttribute("soratra",MappingUrls);
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
                //Class clas = Employer.class;
                        Method fonction = clas.getDeclaredMethod(map.getMethod());
                //fonction.setAccessible(false);
                        ModelView page = (ModelView) fonction.invoke(clas.newInstance());
                        redirection = page.getView();
                    }
                    RequestDispatcher dispat = request.getRequestDispatcher("/Affichage/"+redirection); 
                    dispat.forward(request,response);
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
