<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Centro Comercial CC1</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="*" class="navbar-brand"> Lista de Locales </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Locales</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de locales</h3>
			<hr>
			<div class="container text-left">

			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Nuevo Local</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Número</th>
						<th>Nombre</th>
						<th>Tamaño</th>
						<th>Ventas</th>
						<th>Vende comida</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="local" items="${listLocal}">

						<tr>
							<td><c:out value="${local.numero}" /></td>
							<td><c:out value="${local.nombre}" /></td>
							<td><c:out value="${local.tamaño}" /></td>
							<td><c:out value="${local.ventas}" /></td>
							<td><c:out value="${local.vendeComida}" /></td>
							<td><a href="edit?numero=<c:out value='${local.numero}' />">Editar</a>
								&nbsp;&nbsp;
								<a href="delete?numero=<c:out value='${local.numero}' />">Eliminar</a>
								&nbsp;&nbsp;
								<a href="generar">Generar</a>
								&nbsp;&nbsp;
								<a href="ventas">Ventas</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>