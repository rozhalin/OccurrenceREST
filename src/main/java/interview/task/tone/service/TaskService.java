package interview.task.tone.service;

import interview.task.tone.model.Occurrence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class TaskService {

    public Occurrence getOccurrence(String s) {
        if (s == null || s.isEmpty()) {
            return new Occurrence();
        } else if (s.length() < 1000) {
            return new Occurrence(getOccurrenceMap(s));
        } else {
            return new Occurrence(getOccurrenceArray(s));
        }
    }

    public Map<Character, Long> getOccurrenceMap(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
    }

    class Occur {
        public char c;
        public long l;

        public Occur(char c, long l) {
            this.c = c;
            this.l = l;
        }
    }

    class OccurComparator implements Comparator<Occur> {
        @Override
        public int compare(Occur t1, Occur t2) {
            return Long.compare(t2.l, t1.l);
        }
    }

    public Map<Character, Long> getOccurrenceArray(String s) {
        //final int UNICODE_SYMBOLS_COUNT = 144_697;
        int max = getMaxChar(s);
        Occur[] occurrences = new Occur[max + 1];

        for (char c : s.toCharArray()) {
            if (occurrences[c] != null) {
                Occur occur = occurrences[c];
                occur.l += 1;
            } else {
                occurrences[c] = new Occur(c, 1L);
            }
        }

        return Arrays.asList(occurrences)
                .stream()
                .filter(x -> x != null)
                .sorted(new OccurComparator())
                .collect(Collectors.toMap(x -> x.c, x -> x.l));
    }

    private int getMaxChar(String s) {
        int greatestVal = 0;
        for (int i = 0; i < s.length(); i++) {
            int curVal = (int) s.charAt(i);
            if (curVal > greatestVal)
                greatestVal = curVal;
        }
        return greatestVal;
    }

    public Stream<Occur> getOccurrenceCustom(String s) {
        Map<Character, Occur> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Occur occur = map.get(c);
                occur.l += 1;
            } else {
                map.put(c, new Occur(c, 1));
            }
        }
        return map.values().stream().sorted(new OccurComparator());
    }
}
