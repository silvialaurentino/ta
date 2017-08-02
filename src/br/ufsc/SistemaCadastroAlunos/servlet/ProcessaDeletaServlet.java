package br.ufsc.SistemaCadastroAlunos.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufsc.SistemaCadastroAlunos.dao.AlunoDAO;
import br.ufsc.SistemaCadastroAlunos.domain.Aluno;

public class ProcessaDeletaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		boolean confirmacao = Boolean.valueOf(request.getParameter("confirm"));
		try {
			Aluno aluno = AlunoDAO.buscaAlunoPorMatricula(matricula);
			if (confirmacao) {
				AlunoDAO.excluirAluno(aluno);
				response.sendRedirect("ListaJSP.jsp?notice=Sucesso");
			}
			else {
				response.sendRedirect("ListaJSP.jsp?");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("ListaJSP.jsp?notice=Falha");
		}
	}
}