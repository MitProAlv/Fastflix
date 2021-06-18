package br.com.cadastro.domain;

import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ficha {

		
		@Id
		@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private int customerID;
		
		private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
		
		public void customerID (String fN, String sn, String g, String a) { 
			
			customerID = ID_GENERATOR.getAndIncrement();
		    //rest of constructor
		}
		
		private Integer cpf;
		private String celular;
		private String cep;

		private String nome;
		private String email;
		private String pais;
		private String cidade;
		private String senha;
		private String logradouro;
		private String ncasa;
		private String dtcadastro;
		private String dtnascimento;
	
		
		public Integer getCpf() {
			return cpf;
		}
		public void setCpf(Integer cpf) {
			this.cpf = cpf;
		}
		public String getCelular() {
			return celular;
		}
		public void setCelular(String celular) {
			this.celular = celular;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
	
		}
		public String getLogradouro() {
			return logradouro;
		}
		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}
		public String getNcasa() {
			return ncasa;
		}
		public void setNcasa(String ncasa) {
			this.ncasa = ncasa;
		}
		public String getDtcadastro() {
			return dtcadastro;
		}
		public void setDtcadastro(String dtcadastro) {
			this.dtcadastro = dtcadastro;
		}
		public int getCustomerID() {
			return customerID;
		}
		public void setCustomerID(int customerID) {
			this.customerID = customerID;
		}
		public String getDtnascimento() {
			return dtnascimento;
		}
		public void setDtnascimento(String dtnascimento) {
			this.dtnascimento = dtnascimento;
		}
}

