package com.ufba.support.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ufba.support.model.Chamado;
import com.ufba.support.model.Prioridade;
import com.ufba.support.model.Status;

@Repository 
public class ChamadoRepository {
    private List<Chamado> chamados = new ArrayList<>();
    private long contadorId = 0;

    public ChamadoRepository() {
        // Populando com 10 chamados iniciais de exemplo
        salvar(new Chamado(generateID(), "Erro na impressora HP", "Ana Silva", "TI", Prioridade.ALTA, Status.ABERTO));
        salvar(new Chamado(generateID(), "Lentidão na rede Wi-Fi", "Carlos Souza", "Redes", Prioridade.MEDIA, Status.EM_ANDAMENTO));
        salvar(new Chamado(generateID(), "Troca de toner", "Mariana Costa", "TI", Prioridade.BAIXA, Status.RESOLVIDO));
        salvar(new Chamado(generateID(), "Acesso ao sistema financeiro", "João Pedro", "Financeiro", Prioridade.ALTA, Status.ABERTO));
        salvar(new Chamado(generateID(), "Computador não liga", "Fernanda Lima", "RH", Prioridade.ALTA, Status.EM_ANDAMENTO));
        salvar(new Chamado(generateID(), "Instalação de software de planilha", "Lucas Mendes", "Financeiro", Prioridade.BAIXA, Status.ABERTO));
        salvar(new Chamado(generateID(), "Queda de conexão VPN", "Bruna Oliveira", "Redes", Prioridade.ALTA, Status.ABERTO));
        salvar(new Chamado(generateID(), "Erro de senha no e-mail corporativo", "Ricardo Alves", "TI", Prioridade.MEDIA, Status.RESOLVIDO));
        salvar(new Chamado(generateID(), "Configuração de projetor", "Patrícia Lima", "Marketing", Prioridade.BAIXA, Status.RESOLVIDO));
        salvar(new Chamado(generateID(), "Manutenção preventiva em nobreak", "Marcos Vinicius", "Infraestrutura", Prioridade.MEDIA, Status.EM_ANDAMENTO));
    }

    public Long generateID() {
        return contadorId++;
    }

    // Método para salvar um chamado
    public Chamado salvar(Chamado chamado) {
        chamado.setId(generateID());
        chamados.add(chamado);
        return chamado; 
    }

    // Método para buscar todos os chamados
    public List<Chamado> buscarTodos() {
        return chamados;
    }

    // Método para buscar um chamado por ID
    public Chamado buscarPorId(long id) {
        for (Chamado chamado : chamados) {
            if (chamado.getId() == id) {
                return chamado;
            }
        }
        return null;
    }



}
