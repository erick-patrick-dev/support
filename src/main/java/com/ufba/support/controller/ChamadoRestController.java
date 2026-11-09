package com.ufba.support.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufba.support.model.Chamado;
import com.ufba.support.model.Prioridade;
import com.ufba.support.model.Status;
import com.ufba.support.repository.ChamadoRepository;

@RestController
@RequestMapping("chamados")
public class ChamadoRestController {

    @Autowired
    private ChamadoRepository chamadoRepository;

    //Buscar todos os chamados PRONTO
    @GetMapping
    public ResponseEntity<Iterable<Chamado>> buscarTodos(){
        return ResponseEntity.ok(chamadoRepository.buscarTodos());
    }

    //Buscar chamado por id PRONTO
    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Long id){
        if (id <= 0) {

            return ResponseEntity.badRequest().build();

        } else if (chamadoRepository.buscarPorId(id) == null) {

            return ResponseEntity.notFound().build();

        } else {

            return ResponseEntity.ok(chamadoRepository.buscarPorId(id));
            
        }

    }

    // Filtrar por setor PRONTO
    @GetMapping("/setor")
    public ResponseEntity<Iterable<Chamado>> buscarPorSetor(@RequestParam String nome){

        var chamadosFiltrados = chamadoRepository.buscarTodos().stream()
                .filter(chamado -> chamado.getSetor().equalsIgnoreCase(nome))
                .toList();

        if (chamadosFiltrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(chamadosFiltrados);
        }

    }

    // Filtrar por prioridade
    @GetMapping("/prioridade")
    public ResponseEntity<Iterable<Chamado>> buscarPorPrioridade(@RequestParam String nivel){

        Prioridade nivelEnum = Prioridade.valueOf(nivel.toUpperCase());

        var chamadosFiltrados = chamadoRepository.buscarTodos().stream()
                .filter(chamado -> chamado.getPrioridade().equals(nivelEnum))
                .toList();

        if (chamadosFiltrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(chamadosFiltrados);
        }

    }

    // Buscar pelo titulo
    @GetMapping ("/busca")
    public ResponseEntity<Iterable<Chamado>> buscarPorTitulo(@RequestParam String texto){
        var chamadosFiltrados = chamadoRepository.buscarTodos().stream()
                .filter(chamado -> chamado.getTitulo().toLowerCase().contains(texto.toLowerCase()))
                .toList();

        if (chamadosFiltrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(chamadosFiltrados);
        }
    }

    // Listar chamados de alta prioridade não resolvidos TESTE
    @GetMapping("/criticos")
    public ResponseEntity<Iterable<Chamado>> buscarCriticos(){
        var chamadosFiltrados = chamadoRepository.buscarTodos().stream()
                .filter(chamado -> chamado.getPrioridade() == Prioridade.ALTA && chamado.getStatus() == Status.ABERTO)
                .toList();

        if (chamadosFiltrados.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(chamadosFiltrados);
        }
    }

    // Retornar a quantidade de chamados por status EM TESTE
    @GetMapping("/resumo")
    public ResponseEntity<Map<String, Long>> resumoChamados(){
        return ResponseEntity.ok(chamadoRepository.resumoChamados());
    }

    // Cadastrar, atualizar e deletar chamados PRONTO
    @PostMapping
    public ResponseEntity<Chamado> inserir(@RequestBody Chamado chamado){
        Chamado savedChamado = chamadoRepository.salvar(chamado);
        
        return ResponseEntity.created(null).body(savedChamado);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return null;
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Chamado> atualizar(@PathVariable Long id, @RequestBody Chamado chamado){
    //     return null;
    // }
}
