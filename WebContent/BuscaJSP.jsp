<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="layout/header.html"%>
<h1>Buscar Aluno:</h1>
	<form method='POST' action='./ListaJSP.jsp'>
		<label for='nome'>Nome: </label> <input type='text'
			name='buscaPorNome'>
			<input type='submit' name='submit' value='enviar'>
	</form>