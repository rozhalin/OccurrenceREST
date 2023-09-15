package interview.task.tone.core.algorithms.impls.strategies;

import interview.task.tone.core.algorithms.contracts.OccurrenceStrategy;
import interview.task.tone.core.model.Occurrence;
import interview.task.tone.util.Occur;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Comparator;

public class OccurrenceStreamStrategy implements OccurrenceStrategy {
    @Override
    public Occurrence calculate(String s, Comparator<Occur> comparator) {
        throw new NotImplementedException();
    }
}
