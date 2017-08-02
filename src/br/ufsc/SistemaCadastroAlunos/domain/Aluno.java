package br.ufsc.SistemaCadastroAlunos.domain;

import org.eclipse.jdt.core.compiler.InvalidInputException;

public class Aluno {
	private int matricula;
	private String telefone;
	private String nome;
	private String endereco;

	public Aluno() {

	}

	public Aluno(int matricula, String nome, String endereco, String telefone) {
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Aluno(String nome, String endereco, String telefone) throws InvalidInputException {
		if (!nome.isEmpty() && !endereco.isEmpty() && !telefone.isEmpty()) {
			this.nome = nome;
			this.endereco = endereco;
			this.telefone = telefone;
		} else
			throw new InvalidInputException();
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ "]";
	}

}
