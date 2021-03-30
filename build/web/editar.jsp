<%@page import="com.emergentes.modelo.Agenda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //reg.getId()   datetime-local
    Agenda reg = (Agenda)request.getAttribute("miobjagen");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Actividad en Agenda</h1>
        <form action="MainServlet" method="get">
            <table border="1" cellpadding="1">
                
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly></td>
                </tr>                
                <tr>
                    <td>Fecha y hora</td>
                    <td><input type="datetime-local" name="fecha" value="<%= reg.getFecha()%>"></td>
                </tr>                
                <tr>
                    <td>Actividad</td>
                    <td><input type="text" name="actividad" value="<%= reg.getActividad()%>"></td>
                </tr>                
                <tr>
                    <td>Estado (Si-No-Observaciones)</td>
                    <td><input type="test" name="estado" value="<%= reg.getEstado()%>"></td>
                </tr>                
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar" ></td>
                </tr>                           
            </table>
        </form>
    </body>
</html>
