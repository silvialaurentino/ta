package br.ufsc.SistemaCadastroAlunos.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import br.ufsc.SistemaCadastroAlunos.dao.AlunoDAO;
import br.ufsc.SistemaCadastroAlunos.domain.Aluno;

public class ProcessaIncluiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		try {
			Aluno aluno = new Aluno(nome, endereco, telefone);
			AlunoDAO.inserirAluno(aluno);
			response.sendRedirect("ListaJSP.jsp?notice=Sucesso");
		} catch (InvalidInputException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("ListaJSP.jsp?notice=Falha");
		}
	}

}
