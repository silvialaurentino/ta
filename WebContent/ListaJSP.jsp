<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="layout/header.html"%>
<%
	if (request.getParameter("notice") != null) {
		if (request.getParameter("notice").equals("Sucesso")) {
			out.println("<div class='notice success'>Opera&ccedil;&atilde;o realizada com sucesso!</div>");
		} else if (request.getParameter("notice").equals("Falha")) {
			out.println("<div class='notice failure'>Opera&ccedil;&atilde;o falhou!</div>");
		}
	}
%>
<jsp:include page="/ListaServlet" flush="true" />
<h1>Lista de Alunos:</h1>
<%
	String tabela = (String) request.getAttribute("tabela");
	out.println(tabela);
%>
<form method='POST' action='./ListaJSP.jsp' class="buscaFooter">
	<label for='nome'>Buscar por nome: </label> <input type='text'
		name='buscaPorNome'> <input type='submit' name='submit'
		value='enviar'>
</form>
<%@include file="layout/footer.html"%>