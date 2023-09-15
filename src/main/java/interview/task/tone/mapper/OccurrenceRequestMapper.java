package interview.task.tone.mapper;

import interview.task.tone.core.algorithms.contracts.OccurrenceStrategy;
import interview.task.tone.core.algorithms.impls.comparators.OccurCharAscComparator;
import interview.task.tone.core.algorithms.impls.comparators.OccurCharDescComparator;
import interview.task.tone.core.algorithms.impls.comparators.OccurValueAscComparator;
import interview.task.tone.core.algorithms.impls.comparators.OccurValueDescComparator;
import interview.task.tone.core.algorithms.impls.strategies.OccurrenceArrayStrategy;
import interview.task.tone.core.algorithms.impls.strategies.OccurrenceMapStrategy;
import interview.task.tone.core.algorithms.impls.strategies.OccurrenceStreamStrategy;
import interview.task.tone.core.model.OccurrenceRequest;
import interview.task.tone.dto.OccurrenceRequestDto;
import interview.task.tone.util.Occur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class OccurrenceRequestMapper extends GenericMapper<OccurrenceRequest, OccurrenceRequestDto> {
    private final ModelMapper mapper;

    protected OccurrenceRequestMapper(ModelMapper mapper) {
        super(mapper, OccurrenceRequest.class, OccurrenceRequestDto.class);
        this.mapper = mapper;
    }

    @Override
    public OccurrenceRequest toEntity(OccurrenceRequestDto dto) {
        Comparator<Occur> comparator =
                switch (dto.getCalculationOrder()) {
                    case ORDER_BY_CHARACTER_ASC -> new OccurCharAscComparator();
                    case ORDER_BY_CHARACTER_DESC -> new OccurCharDescComparator();
                    case ORDER_BY_QUANTITY_ASC -> new OccurValueAscComparator();
                    case ORDER_BY_QUANTITY_DESC -> new OccurValueDescComparator();
                    default -> throw new UnsupportedOperationException();
                };
        OccurrenceStrategy strategy = switch (dto.getCalculationType()) {
            case ARRAY -> new OccurrenceArrayStrategy();
            case MAP -> new OccurrenceMapStrategy();
            case STREAM -> new OccurrenceStreamStrategy();
            default -> throw new UnsupportedOperationException();
        };
        return new OccurrenceRequest(dto.getString(), strategy, comparator);
    }
}
