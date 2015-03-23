package com.sampleproblems;

import java.util.Comparator;

/**
 * Natural order comparator
 * 
 * @author Gilberto Osuna
 *
 * @param <T>
 */
public class CompareClass<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(final T o1, final T o2) {
        return o1.compareTo(o2);
    }

}
