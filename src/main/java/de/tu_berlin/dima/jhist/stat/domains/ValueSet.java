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
package de.tu_berlin.dima.jhist.stat.domains;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import de.tu_berlin.dima.jhist.stat.Domain;

/**
 * A value set is an implementation of the {@link Domain} interface. The order is
 * implicitly given by the position of the elements in a collection. 
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 */
public class ValueSet<T> implements Domain<T> {

  //TODO better be backed by array to increase performance?
  private final List<T> set;

  public ValueSet(T... values) {
    Set<T> elems = new HashSet<T>();
    this.set = new ArrayList<T>(values.length);
    for (T value : values) {
      if (!elems.contains(value)) {
        elems.add(value);
        this.set.add(value);
      }
    }
  }

  public ValueSet(Iterable<T> values) {
    Set<T> elems = new HashSet<T>();
    this.set = new ArrayList<T>();
    for (T value : values) {
      if (!elems.contains(value)) {
        elems.add(value);
        this.set.add(value);
      }
    }
  }

  @Override
  public T min() {
    return set.get(0);
  }

  @Override
  public T max() {
    return set.get(set.size() - 1);
  }

  @Override
  public T value(long ordinal) {
    return set.get((int) ordinal);
  }

  @Override
  public long ordinal(T value) {
    return set.indexOf(value);
  }

  @Override
  public long cardinality() {
    return set.size();
  }

  @Override
  public boolean contains(T value) {
    return set.contains(value);
  }

  @Override
  public Domain<T> subDomain(T min, T max) {
    return new ValueSet<T>(set.subList((int) ordinal(min), (int) ordinal(max) + 1));
  }

  @Override
  public Iterator<T> iterator() {
    return set.iterator();
  }

}
