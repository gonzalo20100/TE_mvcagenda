
package com.emergentes.controller;

import com.emergentes.modelo.Agenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion =request.getParameter("op");
        Agenda objagen = new Agenda();
        int id, pos;
        HttpSession ses = request.getSession();
        List<Agenda> lista = (List<Agenda>) ses.getAttribute("listagen");
        switch (opcion){
            case "nuevo":
                //Enviar objeto al editar
                request.setAttribute("miobjagen", objagen);
                request.getRequestDispatcher("editar.jsp").forward(request,response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                // obtener la pocicion del elemto en la colecion
                pos = buscarPorIndice(request,id);
                // obtener objeto
                objagen = lista.get(pos);
                // enviarlo para edicon
                request.setAttribute("miobjagen", objagen);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //obtener la posion del elemto de la coleccion
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                //Actualizamos la lista adebido ala eliminacon
                request.setAttribute("listagen", lista);
                response.sendRedirect("index.jsp");
                break;
                
            default:
                request.setAttribute("listagen", lista);
                response.sendRedirect("index.jsp");
                break;                 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Agenda> lista = (ArrayList<Agenda>) ses.getAttribute("listagen");
        Agenda objagen = new Agenda();
        objagen.setId(id);
        objagen.setFecha(request.getParameter("fecha"));
        objagen.setActividad(request.getParameter("actividad"));
        objagen.setEstado(request.getParameter("estado"));
        System.out.println("El ID es " + id);
        if (id==0) {
            //Colocar el id
            int idNuevo = obtenerId(request);
            objagen.setId(idNuevo);
            
            lista.add(objagen);
            System.out.println(objagen.toString());
        }else{
            //edicion
            int pos = buscarPorIndice(request,id);
            lista.set(pos,objagen);
            System.out.println(objagen.toString());
        }
        System.out.println("Enviando al index");
        request.setAttribute("listagen", lista);
        response.sendRedirect("index.jsp");
    }
     public int buscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        List<Agenda> lista = (List<Agenda>) ses.getAttribute("listagen");
        
        int pos = -1;
        
        if (lista != null) {
            for(Agenda ele : lista){
                ++pos;
                if (ele.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }
     public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Agenda> lista = (ArrayList<Agenda>) ses.getAttribute("listagen");
        // conteo de id desde 0
        int idn = 0;
        for(Agenda ele : lista){
            idn = ele.getId();
        }
        return idn + 1;
    }
}
