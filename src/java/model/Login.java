/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import etu1912.framework.annoter.AnnotationSingle;
import etu1912.framework.annoter.AnnotationUrl;
import etu1912.framework.ModelView;
import etu1912.framework.annoter.AnnotationPrivilege;

/**
 *
 * @author ITU
 */
@AnnotationSingle(ref = "singleton")
public class Login {
    String user;
    String mdp;
    int count = 0;
    public Login() {
    }

    public Login(String user, String mdp) {
        this.user = user;
        this.mdp = mdp;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    @AnnotationUrl(url = "verification")
    public ModelView checkUsers(){
        if(checkUser()){
            ModelView view = new ModelView("main.jsp");
            view.addItemSession("admin",true);
            view.addItemSession("connecter",true);
            System.out.println("Tafiditra ato amin fonctiondet");
            return view;
        }
        ModelView view = new ModelView("main.jsp");
        view.addItemSession("admin",false);
        view.addItemSession("connecter",true);
        return view;
    }
    public boolean checkUser(){
        if(this.getMdp().equals("1234")){
            return true;
        }
        return false;
    }
    @AnnotationUrl(url = "admin")
    public ModelView getValidation(){
        Employer emp = new Employer();
        ModelView view = new ModelView("index.jsp");
        Employer[] e = emp.getInfoEmp();
        view.executeHash("information", e);
        view.setIsJson(true);
        int a = this.count+1;
        System.out.println(a);
        return view;
    }
    
}
