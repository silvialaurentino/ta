package br.ufsc.SistemaCadastroAlunos.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsc.SistemaCadastroAlunos.dao.AlunoDAO;
import br.ufsc.SistemaCadastroAlunos.domain.Aluno;

public class ProcessaEditaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		try {
			Aluno aluno = AlunoDAO.buscaAlunoPorMatricula(matricula);
			if (!request.getParameter("nome").isEmpty()) {
				aluno.setNome(request.getParameter("nome"));
			}
			if (!request.getParameter("endereco").isEmpty()) {
				aluno.setEndereco(request.getParameter("endereco"));
			}
			if (!request.getParameter("telefone").isEmpty()) {
				aluno.setTelefone(request.getParameter("telefone"));
			}
			AlunoDAO.editarAluno(aluno);
			response.sendRedirect("ListaJSP.jsp?notice=Sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("ListaJSP.jsp?notice=Falha");
		}
	}
}