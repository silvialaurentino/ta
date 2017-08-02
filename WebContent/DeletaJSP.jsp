<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="layout/header.html"%>
<jsp:include page="/FormularioDeletaServlet" flush="true" />
<%
	String tabela = (String) request.getAttribute("tabela");
	out.println(tabela);
%>
<%@include file="layout/footer.html"%>