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

/**
 * Represents a discrete domain for a given type. If not stated otherwise a
 * domain is given by the closed interval <code>[min, max]</code>. The
 * cardinality of range <strong>must not</strong> exceed the maximum represented
 * by {@link Long}.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T> the type of the domain
 * @see {@link }
 */
public interface Domain<T> extends Iterable<T> {

  /**
   * Returns the minimum of the domain. The smallest element that is still
   * contained in the domain.
   * @return
   */
  public T min();

  /**
   * Returns the maximum of the domain. The largest element that is still
   * contained in the domain.
   * @return
   */
  public T max();

  /**
   * Returns the value for the ordinal.
   * @param ordinal The position of the value within the domain. The first
   *  element of the domain is at position <code>0</code>.
   * @return
   */
  public T value(long ordinal);

  /**
   * Returns the ordinal for the value.
   * @param value The value to retrieve the position for. If
   *  <code>value == min</code>, then <code>ordinal = 0</code>.
   * @return
   */
  public long ordinal(T value);

  /**
   * Returns the cardinality of the domain. That is the amount of distinct
   * (unique) values contained by the domain.
   * @return
   */
  public long cardinality();

  /**
   * Checks whether the value is contained in this domain or not.
   * @param value
   * @return
   */
  public boolean contains(T value);

  /**
   * Returns the sub-domain of this domain. That is all values between
   * <code>min</code> and <code>max</code>.
   * @param min
   * @param max
   * @return
   */
  public Domain<T> subDomain(T min, T max);

}
