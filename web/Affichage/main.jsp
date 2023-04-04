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
        <% HashMap<String,Mapping> mappingUrls = new HashMap<>();
                
         mappingUrls = (HashMap) request.getAttribute("soratra");%>
        <p>Bienvenue oooo!!</p>
        <% for(HashMap.Entry<String, Mapping>entry : mappingUrls.entrySet()){
            
        %>
            <p><span>Url dans web-xml : </span><% out.println(entry.getKey());%></p>
            <p><span>Nom de la classe dans le mapping : </span><% out.println(entry.getValue().getCla());%></p>
            <p><span>Nom de la method dans le mapping : </span><% out.println(entry.getValue().getMethod());%></p>
        <% } %>
    </body>
</html>
