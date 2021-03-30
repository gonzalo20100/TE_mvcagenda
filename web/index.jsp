
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Agenda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("listagen") == null){
        ArrayList<Agenda> la = new ArrayList<Agenda>();
        session.setAttribute("listagen", la);         
    }
    ArrayList<Agenda> lista = (ArrayList<Agenda>) session.getAttribute("listagen");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mi Agenda</h1>
        <a href="MainServlet?op=nuevo">Nueva actividad</a>
        <table border="1">            
                <tr>
                    <th>Id</th>
                    <th>Fecha y hora</th>
                    <th>Actividad</th>
                    <th>Completado</th>
                    <th></th>
                    <th></th>
                </tr>
                <%
                    if (lista != null) {
                        for (Agenda item : lista) {                           
                %>
                <tr>
                    <td><%= item.getId() %></td>
                    <td><%= item.getFecha() %></td>
                    <td><%= item.getActividad() %></td>
                    <td><%= item.getEstado() %></td>
                    <td><a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a></td>
                    <td><a href="MainServlet?op=eliminar&id=<%= item.getId() %>" 
                           onclick="return(confirm('Esta seguro de eliminar?'))"
                           >Eliminar</a></td>
                </tr>
               <%
                   }
                }
               %>
        </table>
    </body>
</html>
