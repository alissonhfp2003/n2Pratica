package main.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.taskmanager.config.MongoDBConfig;
import com.taskmanager.model.Tarefa;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class TarefaDAO {
    private MongoCollection<Document> collection;

    public TarefaDAO() {
        MongoDatabase database = MongoDBConfig.getDatabase();
        this.collection = database.getCollection("tarefas");
    }

    public void criarTarefa(Tarefa tarefa) {
        Document doc = new Document("titulo", tarefa.getTitulo())
                .append("descricao", tarefa.getDescricao())
                .append("status", tarefa.getStatus())
                .append("data_criacao", tarefa.getDataCriacao());
        collection.insertOne(doc);
    }

    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        for (Document doc : collection.find()) {
            Tarefa tarefa = new Tarefa(
                    doc.getObjectId("_id"),
                    doc.getString("titulo"),
                    doc.getString("descricao"),
                    doc.getString("status")
            );
            tarefa.setDataCriacao(doc.getDate("data_criacao"));
            tarefas.add(tarefa);
        }
        return tarefas;
    }

    public boolean atualizarStatusTarefa(ObjectId id, String novoStatus) {
        Document update = new Document("$set", new Document("status", novoStatus));
        return collection.updateOne(eq("_id", id), update).wasAcknowledged();
    }

    public boolean deletarTarefa(ObjectId id) {
        return collection.deleteOne(eq("_id", id)).wasAcknowledged();
    }
}
