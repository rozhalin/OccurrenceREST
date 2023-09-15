package interview.task.tone.mapper;

import interview.task.tone.dto.OccurrenceRequestDto;
import interview.task.tone.model.OccurrenceRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OccurrenceRequestMapper extends GenericMapper<OccurrenceRequest, OccurrenceRequestDto> {
    private final ModelMapper mapper;

    protected OccurrenceRequestMapper(ModelMapper mapper) {
        super(mapper, OccurrenceRequest.class, OccurrenceRequestDto.class);
        this.mapper = mapper;
    }
}
