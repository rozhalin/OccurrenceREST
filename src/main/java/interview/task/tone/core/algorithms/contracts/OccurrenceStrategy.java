package interview.task.tone.core.algorithms.contracts;

import interview.task.tone.core.model.Occurrence;
import interview.task.tone.util.Occur;

import java.util.Comparator;

public interface OccurrenceStrategy {

    Occurrence calculate(String s, Comparator<Occur> comparator);
}


