package org.serratec.java2backend.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.biblioteca.model.Livro;
import org.serratec.java2backend.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public void salvar(Livro livro) {
		livroRepository.save(livro);
	}
	
	public Livro buscarPorId(Integer idLivro) {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroConsulta = new Livro();
		if(livro.isPresent()) {
			livroConsulta = livro.get();
		}
		return livroConsulta;
	}
	
	public void atualizar(Integer idLivro, Livro livro) {
		Livro livroAt = buscarPorId(idLivro);
		
		if(livro.getTituloLivro() != null) {
			livroAt.setTituloLivro(livro.getTituloLivro());
		}
		if(livro.getTipoLivro() != null) {
			livroAt.setTipoLivro(livro.getTipoLivro());
		}
		if(livro.getAutor() != null) {
			livroAt.setAutor(livro.getAutor());
		}
		if(livro.getDataPublicacao() != null) {
			livroAt.setDataPublicacao(livro.getDataPublicacao());
		}
		livroRepository.save(livroAt);
	}
	
	public void delete(Integer idLivro) {
		livroRepository.deleteById(idLivro);
	}
	
	public List<Livro> listarTodos(){
		return livroRepository.findAll();
	}
	
	public void salvarTodos(List<Livro> listaLivro) {
		livroRepository.saveAll(listaLivro);
	}
	
	

}
