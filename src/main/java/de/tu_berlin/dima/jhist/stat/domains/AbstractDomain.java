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

import java.util.Iterator;

import de.tu_berlin.dima.jhist.stat.Domain;

/**
 * Base class used for most domain implementations.
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 * @see {@link Domain}
 */
public abstract class AbstractDomain<T> implements Domain<T> {

  @Override
  public long cardinality() {
    return ordinal(max()) - ordinal(min()) + 1L;
  }

  @Override
  public boolean contains(T value) {
    return ordinal(min()) <= ordinal(value) && ordinal(value) <= ordinal(max());
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      private int current = 0;

      @Override
      public boolean hasNext() {
        return current < cardinality();
      }

      @Override
      public T next() {
        return value(current++);
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException(
            "Remove operation is not permitted on ranges");
      }
      
    };
  }

}
