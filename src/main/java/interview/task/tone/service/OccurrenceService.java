package interview.task.tone.service;

import interview.task.tone.dto.OccurrenceRequestDto;
import interview.task.tone.mapper.OccurrenceMapper;
import interview.task.tone.model.Occurrence;
import interview.task.tone.model.OccurrenceRequest;
import interview.task.tone.util.OccurrenceCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OccurrenceService {

    private final OccurrenceCalculator occurrenceCalculator;
    private final OccurrenceMapper mapper;

    public OccurrenceService(OccurrenceCalculator occurrenceCalculator, OccurrenceMapper mapper) {
        this.occurrenceCalculator = occurrenceCalculator;
        this.mapper = mapper;
    }

    public Occurrence getOccurrence(String s) {
        return new Occurrence(occurrenceCalculator.calculateOccurrence(s));
    }

    public Occurrence getOccurrence(OccurrenceRequest occurrenceRequest) {
        return new Occurrence(occurrenceCalculator.calculateOccurrence(occurrenceRequest));
    }

}
