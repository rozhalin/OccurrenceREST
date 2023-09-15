package interview.task.tone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OccurrenceRequest extends GenericModel {

    private String string;
    private CalculationType calculationType;
    private CalculationOrder calculationOrder;
}
