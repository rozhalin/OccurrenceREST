package interview.task.tone.service;

import interview.task.tone.core.algorithms.contracts.OccurrenceStrategy;
import interview.task.tone.core.model.OccurrenceRequest;
import interview.task.tone.dto.OccurrenceDto;
import interview.task.tone.mapper.OccurrenceMapper;
import interview.task.tone.util.Occur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Slf4j
@Service
public class OccurrenceService {

    private final OccurrenceMapper mapper;

    public OccurrenceService(OccurrenceMapper mapper) {
        this.mapper = mapper;
    }

    public OccurrenceDto getOccurrence(OccurrenceRequest occurrenceRequest) {
        OccurrenceStrategy strategy = occurrenceRequest.getStrategy();
        Comparator<Occur> comparator = occurrenceRequest.getComparator();
        return mapper.toDto(strategy.calculate(occurrenceRequest.getS(), comparator));
    }

}
