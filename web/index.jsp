<%-- 
    Document   : index
    Created on : 28-03-2021, 11:32:02 AM
    Author     : YURIKIRA105
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Agenda"%>
<%
    if (session.getAttribute("listaper")== null)
    {
        ArrayList<Agenda> la =new ArrayList<Agenda>();
        session.setAttribute("listaper", la);   
    }
    ArrayList<Agenda> lista = (ArrayList<Agenda>)session.getAttribute("listaper");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    </head>
    <body>
        
                    <h1 >Agenda Personal</h1>
                    <a  href="MainServlet?op=nuevo">Nuevo registro</a>
                    <table class="table">
                        <tr>
                            <th>Id</th>
                            <th>Hora</th>
                            <th>Actividad</th>
                            <th>Completado</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <%
                            if(lista !=null){
                                for(Agenda item : lista){

                        %>
                        <tr>
                            <td><%= item.getId() %></td>
                            <td><%= item.getHora() %></td>
                            <td><%= item.getActividad() %></td>                            
                            <td><%= item.getEstado() %></td>
                            <td><a  href="MainServlet?op=editar&id=<%=item.getId() %>">Editar</a></td>
                            <td><a  href="MainServlet?op=eliminar&id=<%=item.getId() %>" onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a></td>
                        </tr>

                        <%
                                }
                            }
                        %>
                    </table>
    </body>
</html>