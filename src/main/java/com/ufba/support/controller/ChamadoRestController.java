package com.ufba.support.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ufba.support.model.Chamado;

@RestController
@RequestMapping("chamados")
public class ChamadoRestController {

    //Buscar todos os chamados
    @GetMapping
    public ResponseEntity<Iterable<Chamado>> buscarTodos(){
        return null;
    }

    //Buscar chamado por id
    @GetMapping("/{id}")
    public ResponseEntity<Chamado> buscarPorId(@PathVariable Long id){
        return null;
    }

    //filtrar por setor
    @GetMapping("/setor")
    public ResponseEntity<Iterable<Chamado>> buscarPorSetor(@RequestParam String setor){
        return null;
    }

    //filtrar por prioridade
    @GetMapping("/prioridade")
    public ResponseEntity<Iterable<Chamado>> buscarPorPrioridade(@RequestParam String prioridade){
        return null;
    }

    //buscar pelo titulo
    @GetMapping ("/busca")
    public ResponseEntity<Iterable<Chamado>> buscarPorTitulo(@RequestParam String texto){
        return null;
    }

    // Listar chamados de alta prioridade não resolvidos
    @GetMapping("/criticos")
    public ResponseEntity<Iterable<Chamado>> buscarCriticos(){
        return null;
    }

    // Retornar a quantidade de chamados por status
    @GetMapping("/resumo")
    public ResponseEntity<String> resumoChamados(){
        return null;
    }

    // Cadastrar, atualizar e deletar chamados
    @PostMapping
    public ResponseEntity<Chamado> inserir(@RequestBody Chamado chamado){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> atualizar(@PathVariable Long id, @RequestBody Chamado chamado){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        return null;
    }
}
