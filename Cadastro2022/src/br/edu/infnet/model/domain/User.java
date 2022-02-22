package br.edu.infnet.model.domain;

public class User {

	private String nome;
	private String email;
	private String pwd;
	
	public User(String nome, String email, String pwd) {
		this.nome = nome;
		this.email = email;
		this.pwd = pwd;
	}
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}