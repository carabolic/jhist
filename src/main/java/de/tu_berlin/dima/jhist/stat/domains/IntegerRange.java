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

import de.tu_berlin.dima.jhist.stat.Domain;

/**
 * This class is a {@link Domain} implementation used to represent integer ranges.
 * An integer range is given by a minimum and maximum integer (inclusive). The
 * cardinality of a integer range is given by <code>max - min + 1</code>. 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 */
public class IntegerRange extends AbstractDomain<Integer> {

  private final int min;
  private final int max;

  public IntegerRange(final int min, final int max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public Integer min() {
    return min;
  }

  @Override
  public Integer max() {
    return max;
  }

  @Override
  public Integer value(long ordinal) {
    return (int) (min + ordinal);
  }

  @Override
  public long ordinal(Integer value) {
    return (long) value - min;
  }

  @Override
  public Domain<Integer> subDomain(Integer min, Integer max) {
    return new IntegerRange(min, max);
  }

}
