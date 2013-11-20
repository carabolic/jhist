package de.tu_berlin.dima.jhist.stat;

import java.util.Collection;

/**
 * This interface is an extension to the {@link Histogram} interface. It allows
 * to add and remove values from the histogram at will.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 * @see {@link Histogram} and {@link Distribution}
 */
public interface DynamicHistogram<T> extends Histogram<T> {

  /**
   * Add one observation for the value to the histogram.
   * @param value
   * @return
   */
  boolean add(T value);

  /**
   * Add all observations from the collection to the histogram.
   * @param values
   * @return
   * @see {@link #add(Object)}
   */
  boolean addAll(Collection<? extends T> values);

  /**
   * Remove one observation for the value from the histogram.
   * @param value
   * @return
   */
  boolean remove(T value);

  /**
   * Remove all observations from the histogram, such that {@link #isEmpty()}
   * returns <code>true</code> after invoking this method.
   */
  void clear();

}
