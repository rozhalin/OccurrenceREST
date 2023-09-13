package interview.task.tone.model;

import interview.task.tone.util.OccurrenceStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Occurrence implements OccurrenceStrategy {
    private Map<Character, Long> data;

    @Override
    public Map<Character, Long> calculateOccurrence(String s) {
        return null;
    }
}
