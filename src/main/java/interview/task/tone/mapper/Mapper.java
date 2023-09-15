package interview.task.tone.mapper;

import interview.task.tone.dto.GenericDto;
import interview.task.tone.core.model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDto> {

    E toEntity(D dto);
    List<E> toEntities(List<D> dtos);

    D toDto(E entity);
    List<D> toDtos(List<E> entities);
}