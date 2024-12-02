package test;

import com.taskmanager.model.Tarefa;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TarefaDAOTest {
    private TarefaDAO tarefaDAO;

    @Before
    public void setUp() {
        tarefaDAO = new TarefaDAO();
    }

    @Test
    public void testCriarTarefa() {
        Tarefa tarefa = new Tarefa(null, "Teste", "Descrição de teste", "Pendente");
        tarefaDAO.criarTarefa(tarefa);
        List<Tarefa> tarefas = tarefaDAO.listarTarefas();
        assertTrue(tarefas.size() > 0);
    }

    @Test
    public void testListarTarefas() {
        List<Tarefa> tarefas = tarefaDAO.listarTarefas();
        assertTrue(tarefas.size() > 0);
    }

    @Test
    public void testAtualizarStatusTarefa() {
        Tarefa tarefa = new Tarefa(null, "Teste", "Descrição de teste", "Pendente");
        tarefaDAO.criarTarefa(tarefa);
        List<Tarefa> tarefas = tarefaDAO.listarTarefas();
        Tarefa tarefaCriada = tarefas.get(0);
        boolean atualizado = tarefaDAO.atualizarStatusTarefa(tarefaCriada.getId(), "Concluído");
        assertTrue(atualizado);
    }

    @Test
    public void testDeletarTarefa() {
        Tarefa tarefa = new Tarefa(null, "Teste", "Descrição de teste", "Pendente");
        tarefaDAO.criarTarefa(tarefa);
        List<Tarefa> tarefas = tarefaDAO.listarTarefas();
        Tarefa tarefaCriada = tarefas.get(0);
        boolean deletado = tarefaDAO.deletarTarefa(tarefaCriada.getId());
        assertTrue(deletado);
    }
}
