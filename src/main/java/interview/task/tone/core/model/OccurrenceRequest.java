package interview.task.tone.core.model;

import interview.task.tone.core.algorithms.contracts.OccurrenceStrategy;
import interview.task.tone.util.Occur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Comparator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OccurrenceRequest extends GenericModel {

    private String s;
    private OccurrenceStrategy strategy;
    private Comparator<Occur> comparator;
}
