<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>local Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="*" class="navbar-brand"> Administrador de Locales </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">local</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${local != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${local == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${local != null}">
            			Edit local
            		</c:if>
						<c:if test="${local == null}">
            			Add New local
            		</c:if>
					</h2>
				</caption>

				

				<fieldset class="form-group">
					<label>Número</label> <input type="text"
						value="<c:out value='${local.numero}' />" class="form-control"
						name="numero" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Nombre</label> <input type="text"
						value="<c:out value='${local.nombre}' />" class="form-control"
						name="nombre">
				</fieldset>

				<fieldset class="form-group">
					<label>Tamaño</label> <input type="text"
						value="<c:out value='${local.tamaño}' />" class="form-control"
						name="tamano">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Vende comidas</label> <input type="text"
						value="<c:out value='${local.vendeComida}' />" class="form-control"
						name="vendeComida">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Ventas</label> <input type="text"
						value="<c:out value='${local.ventas}' />" class="form-control"
						name="ventas">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>