package interview.task.tone.mapper;

import interview.task.tone.dto.OccurrenceDto;
import interview.task.tone.model.Occurrence;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OccurrenceMapper extends GenericMapper<Occurrence, OccurrenceDto> {
    private final ModelMapper mapper;

    protected OccurrenceMapper(ModelMapper mapper) {
        super(mapper, Occurrence.class, OccurrenceDto.class);
        this.mapper = mapper;
    }
}
