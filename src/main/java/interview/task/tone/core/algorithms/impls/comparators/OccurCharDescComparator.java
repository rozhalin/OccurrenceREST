package interview.task.tone.core.algorithms.impls.comparators;

import interview.task.tone.util.Occur;

import java.util.Comparator;

public class OccurCharDescComparator implements Comparator<Occur> {
    @Override
    public int compare(Occur t1, Occur t2) {
        return Character.compare(t2.c, t1.c);
    }
}