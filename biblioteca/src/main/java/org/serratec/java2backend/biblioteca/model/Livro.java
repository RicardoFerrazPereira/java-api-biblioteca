package org.serratec.java2backend.biblioteca.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="livro_cd_id")
	private Integer idLivro;
	
	@NotNull
	@Size(min=5,max=30 )
	@Column(name="livro_tx_titulo_livro")
	private String tituloLivro;
	
	@NotNull
	@Size(min=3,max=20 )
	@Column(name="livro_tx_tipo_livro")
	private String tipoLivro;
	
	@NotNull
	@Size(min=10,max=40 )
	@Column(name="livro_tx_autor")
	private String autor;
	
	@Column(name="livro_dt_publicacao")
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date dataPublicacao;
	
	
	public Livro() {}
		
	
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
