package br.com.fastflix.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

	@Id
	
	private String Nome;
	private String Email;
	private String Senha;
	
	private String Celular;
	private String CPF;

	private String Cadastro;
	private String Nascimento;
	
	private String CEP;
	private String País;
	private String Cidade;
	private String Logradouro;
	

	
	
	
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getDtNadastro() {
		return Cadastro;
	}
	public void setDtNadastro(String dtNadastro) {
		this.Cadastro = dtNadastro;
	}
	public String getDtNascimento() {
		return Nascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.Nascimento = dtNascimento;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public String getPaís() {
		return País;
	}
	public void setPaís(String país) {
		País = país;
	}
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		Cidade = cidade;
	}
	public String getLogradouro() {
		return Logradouro;
	}
	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}
}
