package br.ufsc.SistemaCadastroAlunos.factory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexaoSistema {
	private static final String USUARIO = "root";
	private static final String SENHA = "pudim";
	private static final String URL = "jdbc:mysql://localhost:3306/sistemacadastro";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

}