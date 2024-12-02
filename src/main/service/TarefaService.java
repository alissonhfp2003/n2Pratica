package main.service;

import com.taskmanager.dao.TarefaDAO;
import com.taskmanager.model.Tarefa;
import org.bson.types.ObjectId;

import java.util.List;

public class TarefaService {
    private TarefaDAO tarefaDAO;

    public TarefaService() {
        this.tarefaDAO = new TarefaDAO();
    }

    public void criarTarefa(String titulo, String descricao, String status) {
        Tarefa tarefa = new Tarefa(null, titulo, descricao, status);
        tarefaDAO.criarTarefa(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaDAO.listarTarefas();
    }

    public boolean atualizarStatusTarefa(ObjectId id, String novoStatus) {
        return tarefaDAO.atualizarStatusTarefa(id, novoStatus);
    }

    public boolean deletarTarefa(ObjectId id) {
        return tarefaDAO.deletarTarefa(id);
    }
}
