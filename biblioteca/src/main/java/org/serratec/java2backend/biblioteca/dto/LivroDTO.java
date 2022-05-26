package org.serratec.java2backend.biblioteca.dto;

import java.util.Date;

public class LivroDTO {
	
	private Integer idLivro;
	private String tituloLivro;
	private String tipoLivro;
	private String autor;	
	private Date dataPublicacao;
	
	public LivroDTO() {}
	
	public Integer getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	public String getTituloLivro() {
		return tituloLivro;
	}
	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}
	public String getTipoLivro() {
		return tipoLivro;
	}
	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
}
