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
/**
 *
 * @author YURIKIRA105
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("op");
       Agenda objper =new Agenda();
       int id, pos;
       HttpSession ses= request.getSession();
       List<Agenda> lista =(List<Agenda>) ses.getAttribute("listaper");
       
       switch(opcion)
       {
           case "nuevo":
               //enviar objeto a editar
               request.setAttribute("miobjper", objper);
               request.getRequestDispatcher("Editar.jsp").forward(request, response);
               break;
               
           case "editar":
               id= Integer.parseInt(request.getParameter("id"));
               //Obtener la posicion del elemento en la coleccion
               pos= buscarPorIndice(request, id);
               //Obtener el objeto
               objper=lista.get(pos);
               //Enviar para edicion
               request.setAttribute("miobjper", objper);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               break;
               
           case "eliminar":
               //Obtener la posicion del elemento en la coleccion
               id = Integer.parseInt(request.getParameter("id"));
               pos=buscarPorIndice(request, id);
               if(pos >=0)
               {
                   lista.remove(pos);
               }
               //Actulizamos la lista debido a la eliminacion
               request.setAttribute("listaper", lista);
               response.sendRedirect("index.jsp");
               break;
               
           default:
               request.setAttribute("listaper", lista);
               response.sendRedirect("index.jsp");
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        HttpSession ses=request.getSession();
        ArrayList<Agenda> lista=(ArrayList<Agenda>)ses.getAttribute("listaper");
        Agenda objper=new Agenda();
        
        objper.setId(id);  
        objper.setNombres(request.getParameter("nombres"));
        objper.setApellidos(request.getParameter("apellidos"));
        objper.setEdad(Integer.parseInt(request.getParameter("edad")));
        objper.setHora(request.getParameter("hora"));
        objper.setActividad(request.getParameter("actividad"));
        objper.setEstado(request.getParameter("estado"));
        
        System.out.println("El ED es "+id);
        
        if(id==0)
        {
            //Colocar el ID
            int idNuevo=obtenerId(request);
            objper.setId(idNuevo);
            
            lista.add(objper);
            System.out.println(objper.toString());
        }
        else
        {
            //edicion
            int pos= buscarPorIndice(request, id);
            lista.set(pos, objper);
            System.out.println(objper.toString()); 
        }
        System.out.println("Envian as index");
        request.setAttribute("listaper", lista);
        response.sendRedirect("index.jsp");
    }

    
   public int buscarPorIndice(HttpServletRequest request, int id)
    {
        HttpSession ses = request.getSession();
        List<Agenda> lista =(List<Agenda>) ses.getAttribute("listaper");
        
        int pos=-1;
        
        if(lista !=null)
        {
            for (Agenda ele : lista)
            {
                ++pos;
                if(ele.getId()==id)
                {
                    break;
                }
            }
        }
        return pos;

    }
    
    public int obtenerId(HttpServletRequest request)
    {
        HttpSession ses = request.getSession();
        List<Agenda> lista =(List<Agenda>) ses.getAttribute("listaper");
        //Conteo de Id desde 0
        int idn=0;
        
        for (Agenda ele : lista)
        {
            idn=ele.getId();
        }
        
        return idn+1;

    }

}
