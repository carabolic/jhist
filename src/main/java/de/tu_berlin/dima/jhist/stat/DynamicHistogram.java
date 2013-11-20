/*******************************************************************************
 * Copyright 2013 DIMA Research Group, TU Berlin (http://www.dima.tu-berlin.de)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
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
