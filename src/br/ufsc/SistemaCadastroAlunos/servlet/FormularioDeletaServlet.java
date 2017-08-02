package br.ufsc.SistemaCadastroAlunos.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsc.SistemaCadastroAlunos.dao.AlunoDAO;
import br.ufsc.SistemaCadastroAlunos.domain.Aluno;

public class FormularioDeletaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String tabela = "";
			int matricula = Integer.parseInt(request.getParameter("matricula"));
			Aluno aluno = AlunoDAO.buscaAlunoPorMatricula(matricula);

			tabela += "<!DOCTYPE html>";
			tabela += "<html>";
			tabela += "<head>";
			tabela += "<title>Excluir Aluno</title>";
			tabela += "</head>";
			tabela += "<body>";
			tabela += "<h1>Excluir Aluno</h1>";
			tabela += "<table><tr><th>Matricula</th><th>Nome</th><th>Endereço</th><th>Telefone</th></tr>";
			tabela += "<tr>";
			tabela += "<td>" + aluno.getMatricula() + "</td>";
			tabela += "<td>" + aluno.getNome() + "</td>";
			tabela += "<td>" + aluno.getEndereco() + "</td>";
			tabela += "<td>" + aluno.getTelefone() + "</td>";
			tabela += "<td>" + " " + "</td>";
			tabela += "</tr>";
			tabela += "</table>";
			tabela += "<h3>Desejas realmente excluir o aluno selecionado?</h3>";
			tabela += "<form method='POST' action='./ProcessaDeletaServlet'>";
			tabela += "<input type='radio' name='confirm' value='true'> Sim<br>";
			tabela += "<input type='radio' name='confirm' value='false' checked> Não<br>";
			tabela += "<input type='hidden' name='matricula' value='" + matricula + "'";
			tabela += "<br><input type='submit' name='submit' value='submit'></fieldset></form>";
			request.setAttribute("tabela", tabela);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
