package br.ufsc.SistemaCadastroAlunos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufsc.SistemaCadastroAlunos.domain.*;
import br.ufsc.SistemaCadastroAlunos.factory.ConexaoSistema;

public class AlunoDAO {

	public static void inserirAluno(Aluno aluno) throws SQLException {
		StringBuilder SQL = new StringBuilder();
		SQL.append("INSERT INTO alunos ");
		SQL.append("(nome, telefone, endereco) ");
		SQL.append("VALUES (?, ?, ?)");

		Connection conexao = ConexaoSistema.conectar();
		PreparedStatement comando = conexao.prepareStatement(SQL.toString());

		comando.setString(1, aluno.getNome());
		comando.setString(2, aluno.getTelefone());
		comando.setString(3, aluno.getEndereco());
		comando.executeUpdate();
	}

	public static void excluirAluno(Aluno aluno) throws SQLException {
		StringBuilder SQL = new StringBuilder();
		SQL.append("DELETE FROM alunos ");
		SQL.append("WHERE matricula = ? ");

		Connection conexao = ConexaoSistema.conectar();
		PreparedStatement comando = conexao.prepareStatement(SQL.toString());

		comando.setInt(1, aluno.getMatricula());
		comando.executeUpdate();
	}

	public static void editarAluno(Aluno aluno) throws SQLException {
		StringBuilder SQL = new StringBuilder();
		SQL.append("UPDATE alunos ");
		SQL.append("SET endereco = ?, nome = ?, telefone = ? ");
		SQL.append("WHERE matricula = ? ");

		Connection conexao = ConexaoSistema.conectar();
		PreparedStatement comando = conexao.prepareStatement(SQL.toString());

		comando.setString(1, aluno.getEndereco());
		comando.setString(2, aluno.getNome());
		comando.setString(3, aluno.getTelefone());
		comando.setInt(4, aluno.getMatricula());

		comando.executeUpdate();
	}

	private static ArrayList<Aluno> montaLista(ResultSet resultado) throws SQLException {
		ArrayList<Aluno> lista = new ArrayList<Aluno>();

		while (resultado.next()) {
			Aluno a = new Aluno();
			a.setMatricula(resultado.getInt("matricula"));
			a.setNome(resultado.getString("nome"));
			a.setEndereco(resultado.getString("endereco"));
			a.setTelefone(resultado.getString("telefone"));
			lista.add(a);
		}
		return lista;
	}

	public static Aluno buscaAlunoPorMatricula(int matricula) throws SQLException {
		StringBuilder SQL = new StringBuilder();
		SQL.append("SELECT matricula, nome, endereco, telefone ");
		SQL.append("FROM alunos ");
		SQL.append("WHERE matricula = ? ");

		Connection conexao = ConexaoSistema.conectar();
		PreparedStatement comando = conexao.prepareStatement(SQL.toString());
		comando.setInt(1, matricula);

		ResultSet resultado = comando.executeQuery();
		Aluno retorno = null;

		try {
			if (resultado.next()) {
				retorno = new Aluno();
				retorno.setMatricula(resultado.getInt("matricula"));
				retorno.setNome(resultado.getString("nome"));
				retorno.setEndereco(resultado.getString("endereco"));
				retorno.setTelefone(resultado.getString("telefone"));
			}
		} catch (SQLException e) {
			System.out.println("opa");
			e.printStackTrace();
		}
		return retorno;
	}

	public static ArrayList<Aluno> buscaAlunoPorNome(String nome) throws SQLException {
		StringBuilder SQL = new StringBuilder();
		SQL.append("SELECT matricula, nome, endereco, telefone ");
		SQL.append("FROM alunos ");
		SQL.append("WHERE nome LIKE ? ");
		SQL.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoSistema.conectar();
		PreparedStatement comando = conexao.prepareStatement(SQL.toString());

		comando.setString(1, "%" + nome + "%");
		ResultSet resultado = comando.executeQuery();

		return montaLista(resultado);
	}

	public static ArrayList<Aluno> listarAlunos() throws SQLException {
		StringBuilder SQL = new StringBuilder();
		SQL.append("SELECT matricula, nome, endereco, telefone ");
		SQL.append("FROM alunos ");
		SQL.append("ORDER BY matricula ASC ");

		Connection conexao = ConexaoSistema.conectar();
		PreparedStatement comando = conexao.prepareStatement(SQL.toString());

		ResultSet resultado = comando.executeQuery();

		return montaLista(resultado);
	}

}