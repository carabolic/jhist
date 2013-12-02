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
 * This class is a {@link Domain} implementation used to represent long ranges.
 * An long range is given by a minimum and maximum integer (inclusive). The
 * cardinality of a integer range is given by <code>max - min + 1</code>.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 */
public class LongRange extends AbstractMinMaxDomain<Long> {

  public LongRange(long min, long max) {
    super(min, max);
  }

  @Override
  public Long value(long ordinal) {
    return min() + ordinal;
  }

  @Override
  public long ordinal(Long value) {
    return value - min();
  }

  @Override
  public Domain<Long> subDomain(Long min, Long max) {
    return new LongRange(min, max);
  }

}
