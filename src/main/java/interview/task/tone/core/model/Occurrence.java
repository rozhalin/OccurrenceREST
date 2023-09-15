package interview.task.tone.core.model;

import interview.task.tone.util.Occur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Occurrence extends GenericModel {
    private Iterable<Occur> data;

}
