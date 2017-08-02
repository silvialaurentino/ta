package br.ufsc.SistemaCadastroAlunos.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsc.SistemaCadastroAlunos.dao.AlunoDAO;
import br.ufsc.SistemaCadastroAlunos.domain.Aluno;

public class ListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String tabela = "";
			String nome = request.getParameter("buscaPorNome");
			ArrayList<Aluno> listaAlunos;
			if (nome != null) {
				listaAlunos = AlunoDAO.buscaAlunoPorNome(nome);
				tabela += "<h2>Resultado da busca por \"" + nome + "\":</h2>";
			} else {
				listaAlunos = AlunoDAO.listarAlunos();
			}
			tabela += "<table><tr><th>Matricula</th><th>Nome</th><th>Endere&ccedil;o</th><th>Telefone</th><th></th></tr>";
			for (Aluno aluno : listaAlunos) {
				tabela += "<tr>";
				tabela += "<td class=\"matricula\">" + aluno.getMatricula() + "</td>";
				tabela += "<td>" + aluno.getNome() + "</td>";
				tabela += "<td>" + aluno.getEndereco() + "</td>";
				tabela += "<td>" + aluno.getTelefone() + "</td>";
				tabela += "<td><a href=\"EditaJSP.jsp?matricula=" + aluno.getMatricula() + "\">Editar</a> ";
				tabela += "";
				tabela += "<a href=\"DeletaJSP.jsp?matricula=" + aluno.getMatricula() + "\">Excluir</a>";
				tabela += "</tr>";
				tabela += "</td>";
			}
			tabela += "</table>";
			request.setAttribute("tabela", tabela);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}