package service;

import model.LogSistema;
import repository.LogRepository;
import java.util.List;

public class LogService {

    private LogRepository repository = new LogRepository();

    public void registrar(String usuario, String acao) {

        LogSistema log = new LogSistema(usuario, acao);

        repository.salvar(log);
    }

    public List<LogSistema> listarTodos() {

        return repository.listarTodos();
    }
}
