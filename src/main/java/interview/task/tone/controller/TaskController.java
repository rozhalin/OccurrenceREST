package interview.task.tone.controller;

import interview.task.tone.model.Occurrence;
import interview.task.tone.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(description = "Получить частоту встречи символов", method = "getOccurrences")
    @GetMapping("/occurrences")
    public ResponseEntity<Occurrence> getOccurrences(@RequestParam String s) {
        return ResponseEntity.ok().body(service.getOccurrence(s));
    }
}
