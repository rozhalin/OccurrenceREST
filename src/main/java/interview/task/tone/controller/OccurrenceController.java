package interview.task.tone.controller;

import interview.task.tone.dto.OccurrenceDto;
import interview.task.tone.dto.OccurrenceRequestDto;
import interview.task.tone.mapper.OccurrenceMapper;
import interview.task.tone.mapper.OccurrenceRequestMapper;
import interview.task.tone.model.Occurrence;
import interview.task.tone.service.OccurrenceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/task")
public class OccurrenceController {

    private final OccurrenceService service;
    private final OccurrenceRequestMapper requestMapper;
    private final OccurrenceMapper mapper;

    public OccurrenceController(OccurrenceService service, OccurrenceRequestMapper requestMapper, OccurrenceMapper mapper) {
        this.service = service;
        this.requestMapper = requestMapper;
        this.mapper = mapper;
    }

    @Operation(description = "Получить частоту встречи символов", method = "getOccurrences")
    @GetMapping("/occurrences")
    public ResponseEntity<OccurrenceDto> getOccurrence(@RequestParam String s) {
        return ResponseEntity.ok().body(mapper.toDto(service.getOccurrence(s)));
    }

    @Operation(description = "Получить частоту встречи символов, необходимо передать строку, выбрать метод" +
            "подсчета и сортировки")
    @PostMapping("/occurrences")
    public ResponseEntity<OccurrenceDto> getOccurrence(@RequestBody OccurrenceRequestDto occurrenceRequestDto) {
        return ResponseEntity.ok().body(
                mapper.toDto(service.getOccurrence(requestMapper.toEntity(occurrenceRequestDto))));
    }
}
