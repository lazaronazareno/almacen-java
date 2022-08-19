<%-- 
    Document   : uploadForm
    Created on : 18 ago 2022, 19:07:39
    Author     : lazar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Nuevo Producto</title>
    </head>
    <style type="text/css">
        form, body {display: flex; flex-direction: column; align-items: center;}
        .product-form {height: 70vh}
        form p, form select, form div {width: 60vw}
        .background { background: rgb(255,77,66);background: linear-gradient(145deg, rgba(255,77,66,1) 0%, rgba(127,226,117,1) 100%); min-height: 100vh;}
    </style>
    
    <body class="background">
        <h1 class="d-flex">Almacén de Misiones</h1>
        <h2 class="d-flex">Cargar Producto</h2>
        <form class="form-group justify-content-evenly product-form" action="SvSuperMarket" method="POST">
            <select class="form-select" name="tipoComida">
                <option selected>Tipo de Comida</option>
                <option value="carne y pescado">Carnes y pescados</option>
                <option value="frutas y verduras">Frutas y verduras</option>
                <option value="huevos">Huevos</option>
                <option value="lacteos">Lacteos</option>
                <option value="arroz">Arroz</option>
                <option value="fideos">Fideos</option>
                <option value="enlatados">Enlatados</option>
                <option value="legumbres">Legumbres</option>
                <option value="frutos secos y deshidratados">Frutos secos y deshidratados</option>
                <option value="limpieza">Limpieza</option>
                <option value="bazar">Bazar</option>
                <option value="cuidado personal">Cuidado personal</option>
                <option value="otros">otros</option>
            </select>
            <div class="form-floating">
                <input class="form-control" id="floatingInput" placeholder="Producto" required type="text" name="nombre" >
                <label for="floatingInput">Producto: </label>
            </div>
            <div class="form-floating">
                <input class="form-control" id="floatingInput" placeholder="Precio de costo" required type="text" name="precioCosto">
                <label for="floatingInput">Precio de costo </label>
            </div>
            <div class="form-floating">
                <input class="form-control" id="floatingInput" placeholder="Precio de Venta" required type="text" name="precioVenta">
                <label for="floatingInput">Precio de Venta </label>
            </div>
            <div class="form-floating">
                <input class="form-control" id="floatingInput" placeholder="Stock" required type="text" name="stock" >
                <label for="floatingInput">Stock: </label>
            </div>
            <button class="btn btn-warning" type="submit">Cargar</button>
        </form>
        
        <form action="SvSuperMarket" method="GET">
            <button class="btn btn-warning" type="submit">Mostrar Productos</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
