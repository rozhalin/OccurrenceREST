package interview.task.tone.core.algorithms.impls.comparators;

import interview.task.tone.util.Occur;

import java.util.Comparator;

public class OccurValueDescComparator implements Comparator<Occur> {

    @Override
    public int compare(Occur o1, Occur o2) {
        if (o1.l.compareTo(o2.l) == 0) {
            return o2.c.compareTo(o1.c);
        } else {
            return o2.l.compareTo(o1.l);
        }
    }
}