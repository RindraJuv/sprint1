<%@page import="model.Employer"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="etu1912.framework.Mapping"%>
<html>
    <head>
        <title>title</title>
        <style>
            p{
                font-family: arial;
                font-size: 20px;
                font-weight: bold;
                color : blue;
            }
            span{
                color:black;
                font-size: 20px;
            }
            
        </style>
    </head>
    <body>
        <% 
           Employer[] emp = (Employer[]) request.getAttribute("information");
        %>
        <p>Bienvenue oooo!!</p>
        <% for(int i = 0; i<emp.length;i++){
      
        %>
            <p><span>Nom : </span><% out.println(emp[i].getNom());%></p>
            <p><span>Prenom : </span><% out.println(emp[i].getPrenom());%></p>
            <p><span>Fonction : </span><% out.println(emp[i].getFonction());%></p>
        <% } %>
    </body>
</html>
