package org.serratec.java2backend.biblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.java2backend.biblioteca.dto.LivroDTO;
import org.serratec.java2backend.biblioteca.exception.LivroException;
import org.serratec.java2backend.biblioteca.model.Livro;
import org.serratec.java2backend.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public LivroDTO converterModelEmDto(Livro livro, LivroDTO livroDTO) {
		
		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTituloLivro(livro.getTituloLivro());
		livroDTO.setTipoLivro(livro.getTipoLivro());
		livroDTO.setAutor(livro.getAutor());
		livroDTO.setDataPublicacao(livro.getDataPublicacao());
		
		return livroDTO;
	}
	public Livro converterDtoEmModel(LivroDTO livroDTO, Livro livro) {
			
		livro.setTituloLivro(livroDTO.getTituloLivro());
		livro.setTipoLivro(livroDTO.getTipoLivro());
		livro.setAutor(livroDTO.getAutor());
		livro.setDataPublicacao(livroDTO.getDataPublicacao());
		
		return livro;
	}
			
	public String salvar(LivroDTO livroDTO) {
		Livro livro = new Livro();
		Livro livroSalvar = converterDtoEmModel(livroDTO, livro);
		livroRepository.save(livroSalvar);
		return ("Livro criado com sucesso id: " + livro.getIdLivro());
	}
	
	public LivroDTO buscarPorId(Integer idLivro) throws LivroException {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		
		Livro livroConsulta = new Livro();
		LivroDTO livroDTO = new LivroDTO(); 
		
		if(livro.isPresent()) {
			livroConsulta = livro.get();
			livroDTO = converterModelEmDto(livroConsulta, livroDTO);
			return livroDTO;
		}
		throw new LivroException("Livro com Id informado não encontrado");
	}
	
	public String atualizar(Integer idLivro, LivroDTO livroDTO) throws LivroException {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroAt = new Livro();
		
		if(livro.isPresent()) {
			livroAt = livro.get();
			
			if(livroDTO.getTituloLivro() != null) {
				livroAt.setTituloLivro(livroDTO.getTituloLivro());
			}
			if(livroDTO.getTipoLivro() != null) {
				livroAt.setTipoLivro(livroDTO.getTipoLivro());
			}
			if(livroDTO.getAutor() != null) {
				livroAt.setAutor(livroDTO.getAutor());
			}
			if(livroDTO.getDataPublicacao() != null) {
				livroAt.setDataPublicacao(livroDTO.getDataPublicacao());
			}
			livroRepository.save(livroAt);
			return "O Livro foi atualizado!";
		}
		throw new LivroException("O Livro não foi atualizado!");
		
	}
	
	public void delete(Integer idLivro) {
		livroRepository.deleteById(idLivro);
	}
	
	public List<LivroDTO> listarTodos(){
		List<Livro> listaLivroModel = livroRepository.findAll();
		List<LivroDTO> listaLivroDTO = new ArrayList<>();
		for (Livro livro : listaLivroModel) {
			LivroDTO livroDTO = new LivroDTO();
			converterModelEmDto(livro, livroDTO);
			listaLivroDTO.add(livroDTO);
		}
		return listaLivroDTO;
	}
	
	public void salvarTodos(List<LivroDTO> listaLivroDTO) {
		List<Livro> salvarLivros = new ArrayList<>();
		
		for (LivroDTO livroDTO : listaLivroDTO) {
			Livro livroSave = new Livro();
			converterDtoEmModel(livroDTO, livroSave);
			salvarLivros.add(livroSave);
			
		}
		livroRepository.saveAll(salvarLivros);
	}
	
	

}
