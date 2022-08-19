<%-- 
    Document   : products
    Created on : 18 ago 2022, 20:02:46
    Author     : lazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="Servlets.Producto" %>
<%@ page import ="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Productos</title>
    </head>
    <style type="text/css">
        body {min-height: 100vh; display: flex; flex-direction: column; align-items: center;}
        .background { background: rgb(255,77,66);background: linear-gradient(145deg, rgba(255,77,66,1) 0%, rgba(127,226,117,1) 100%);}
    </style>
    <body class="background">
        <h1>Productos</h1>
        <table class="table table-danger table-striped">
            <thead>
              <tr>
                <th class="tg-t0bo">Tipo de Alimento</th>
                <th class="tg-t0bo">Nombre</th>
                <th class="tg-t0bo">Precio de Costo</th>
                <th class="tg-t0bo">Precio de Venta</th>
                <th class="tg-t0bo">Stock</th>
              </tr>
            </thead>
            <tbody>
            <%
                List<Producto> listaProductos = (List)  request.getSession().getAttribute("listaProductos");
                int cont=1;
                for (Producto prod : listaProductos) { %>
                <tr>
                    <td class="tg-0pky"><%=prod.getTipo()%></td>
                    <td class="tg-0pky"><%=prod.getNombre()%></td>
                    <td class="tg-0pky"><%=prod.getPrecioCosto()%></td>
                    <td class="tg-0pky"><%=prod.getPrecioVenta()%></td>
                    <td class="tg-0pky"><%=prod.getStock()%></td>
                </tr>
                <% cont = cont+1; %>
            <%}%>
            </tbody>
        </table>
        <form action="uploadForm.jsp">
            <button class="btn btn-warning" type="submit">Cargar nuevo Producto</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
