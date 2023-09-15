package interview.task.tone.util;

import interview.task.tone.model.OccurrenceRequest;

public interface OccurrenceStrategy {
    String calculateOccurrence(String s);

    String calculateOccurrence(OccurrenceRequest occurrenceRequest);
}
