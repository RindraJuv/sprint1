/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu1912.framework;

import java.util.HashMap;
/**
 *
 * @author ITU
 */
public class ModelView {
    String view;
    HashMap<String,Object> liste = new HashMap<>();
    HashMap<String,Boolean> admin = new HashMap<>();
    boolean isJson = false;

    public boolean isIsJson() {
        return isJson;
    }

    public void setIsJson(boolean isJson) {
        this.isJson = isJson;
    }
    public ModelView(String view) {
        this.view = view;
    }

    public ModelView(String view, HashMap<String, Object> liste) {
        this.view = view;
        this.liste = liste;
    }

    public ModelView() {
    }

    public HashMap<String, Boolean> getAdmin() {
        return admin;
    }

    public void setAdmin(HashMap<String, Boolean> admin) {
        this.admin = admin;
    }
    
    public String getView() {
        return view;
    }

    public HashMap<String, Object> getListe() {
        return liste;
    }

    
    public void executeHash(String n,Object o){
      this.liste.put(n,o);
    }
    
    public void addItemSession(String key, boolean b){
        this.admin.put(key,b);
    }
}
