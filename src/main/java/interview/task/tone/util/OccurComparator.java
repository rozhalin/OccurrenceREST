package interview.task.tone.util;

import java.util.Comparator;

class OccurComparator implements Comparator<Occur> {
    @Override
    public int compare(Occur t1, Occur t2) {
        return Long.compare(t2.l, t1.l);
    }
}