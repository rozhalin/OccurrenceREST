package interview.task.tone.util;

import java.util.Map;

public interface OccurrenceStrategy {
    Map<Character, Long> calculateOccurrence(String s);
}
