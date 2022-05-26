package org.serratec.java2backend.biblioteca.controller;

import java.util.List;

import org.serratec.java2backend.biblioteca.model.Livro;
import org.serratec.java2backend.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {
	
	
	@Autowired
	LivroService livroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<Void> salvar(@RequestBody Livro livro) {
		livroService.salvar(livro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/buscar/{idLivro}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable Integer idLivro){
		return ResponseEntity.ok(livroService.buscarPorId(idLivro));
	}
	
	@PutMapping("/atualizar/{idLivro}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idLivro, @RequestBody Livro livro){
		livroService.atualizar(idLivro, livro);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{idLivro}")
	public ResponseEntity<Void> delete(@PathVariable Integer idLivro) {
		livroService.delete(idLivro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@GetMapping("/lista")
	public ResponseEntity<List<Livro>> listaTodos(){
		return ResponseEntity.ok(livroService.listarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<Livro> listaLivro){
		livroService.salvarTodos(listaLivro);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
}
