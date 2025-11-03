package br.com.fatec.api_links_uteis.controller;

import br.com.fatec.api_links_uteis.model.Disciplina;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    private final Map<Long, Disciplina> bancoDeDados = new HashMap<>();
    private Long proximoId = 3L;

    public DisciplinaController() {
        // Inicializa com duas disciplinas do curso de DSM
        bancoDeDados.put(1L, new Disciplina(1L, "Desenvolvimento Web I", 80, "Prof. João Silva"));
        bancoDeDados.put(2L, new Disciplina(2L, "Banco de Dados", 80, "Prof. Maria Santos"));
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarTodas() {
        List<Disciplina> disciplinas = new ArrayList<>(bancoDeDados.values());
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id) {
        Disciplina disciplina = bancoDeDados.get(id);
        if (disciplina == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(disciplina);
    }

    @PostMapping
    public ResponseEntity<Disciplina> criar(@RequestBody Disciplina disciplina) {
        disciplina.setId(proximoId++);
        bancoDeDados.put(disciplina.getId(), disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplina);
    }
}
