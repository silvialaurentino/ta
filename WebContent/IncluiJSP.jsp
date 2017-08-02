<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="layout/header.html"%>
<body>
	<h1>Incluir Aluno:</h1>
	<form method='POST' action='./ProcessaIncluiServlet'>
		<label for='nome'>Nome: </label>
		<input type='text' name='nome'><br>
		<label for='nome'>Endereço: </label>
		<input type='text' name='endereco'><br>
		<label for='nome'>Telefone: </label>
		<input type='text' name='telefone'>
		<input type='submit' name='submit' value='enviar'>
	</form>	
	<%@include file="layout/footer.html"%>