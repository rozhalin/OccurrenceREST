package interview.task.tone.core.algorithms.impls.strategies;

import interview.task.tone.core.algorithms.contracts.OccurrenceStrategy;
import interview.task.tone.core.model.Occurrence;
import interview.task.tone.util.Occur;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class OccurrenceArrayStrategy implements OccurrenceStrategy {
    @Override
    public Occurrence calculate(String s, Comparator<Occur> comparator) {
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

        return new Occurrence(set);
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
}
