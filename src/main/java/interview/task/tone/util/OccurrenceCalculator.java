package interview.task.tone.util;

import interview.task.tone.model.OccurrenceRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OccurrenceCalculator implements OccurrenceStrategy {

    private Comparator<Occur> comparator = new OccurComparator();

    @Override
    public String calculateOccurrence(String s) {
        return getOccurrenceMap(s);
    }

    @Override
    public String calculateOccurrence(OccurrenceRequest occurrenceRequest) {
        return "null";
    }

    public String getOccurrenceMap(String s) {
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
                                (e1, e2) -> e1, LinkedHashMap::new))
                .toString();
    }

//    public String getOccurrenceMapOccur(String s) {
//        return s.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .map(e -> new Occur(e.getKey(), e.getValue()))
//
//
//    }


    private String getOccurrenceArray(String s) {
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

        Set<Occur> set = new TreeSet<>(comparator);
        for (Occur occurrence : occurrences) {
            if (occurrence != null) {
                set.add(occurrence);
            }
        }

        return set.toString();
    }

    private String occurArrayToString(Occur[] array) {
        StringBuilder sb = new StringBuilder();
        for (Occur occur : array) {
            if (occur != null) {
                if (sb.isEmpty()) {
                    sb.append(occur);
                } else {
                    sb.append(", ").append(occur);
                }
            }
        }
        return sb.toString();
    }

    private int getMaxChar(String s) {
        int greatestVal = 0;
        for (int i = 0; i < s.length(); i++) {
            int curVal = s.charAt(i);
            if (curVal > greatestVal)
                greatestVal = curVal;
        }
        return greatestVal;
    }

    public String getOccurrenceCustom(String s) {
        Map<Character, Occur> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Occur occur = map.get(c);
                occur.l += 1;
            } else {
                map.put(c, new Occur(c, 1L));
            }
        }
        return map.values().stream().sorted(new OccurComparator()).toString();
    }

}