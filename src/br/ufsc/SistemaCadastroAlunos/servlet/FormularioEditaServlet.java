package br.ufsc.SistemaCadastroAlunos.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsc.SistemaCadastroAlunos.dao.AlunoDAO;
import br.ufsc.SistemaCadastroAlunos.domain.Aluno;

public class FormularioEditaServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	@Override
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
			tabela += "<title>Editar Aluno</title>";
			tabela += "</head>";
			tabela += "<body>";
			tabela += "<h1>Editar Aluno</h1>";
			tabela += "<table><tr><th>Matricula</th><th>Nome</th><th>Endereço</th><th>Telefone</th></tr>";
			tabela += "<tr>";
			tabela += "<td>" + aluno.getMatricula() + "</td>";
			tabela += "<td>" + aluno.getNome() + "</td>";
			tabela += "<td>" + aluno.getEndereco() + "</td>";
			tabela += "<td>" + aluno.getTelefone() + "</td>";
			tabela += "</tr>";
			tabela += "</table>";
			tabela += "<form method='POST' action='./ProcessaEditaServlet'>";
			tabela += "<label for='nome'>Nome: </label>";
			tabela += "<input type='text' name='nome'>";
			tabela += "<br><label for='endereco'>Endere&ccedil;o: </label>";
			tabela += "<input type='text' name='endereco'>";
			tabela += "<br><label for='telefone'>Telefone: </label>";
			tabela += "<input type='text' name='telefone'>";
			tabela += "<input type='hidden' name='matricula' value='" + matricula + "'";
			tabela += "<br><input type='submit' name='submit' value='enviar'></fieldset></form>";
			request.setAttribute("tabela", tabela);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
