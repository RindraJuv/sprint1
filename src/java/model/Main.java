/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author ITU
 */
public class Main {
    public static void main(String[] args){
        Object e = new Employer();
        Field[] f = e.getClass().getDeclaredFields();
        System.out.println(f[0].getName());
        try{
            //int a = 2;
            Method met = e.getClass().getMethod("setId", int.class);
            //Class[] c = met[a].getParameterTypes();
            int a = 10;
            met.invoke(e, a);
            Employer emp = (Employer) e;
            //System.out.println(met[a].getName());
            System.out.println(emp.getId());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
    }
}
