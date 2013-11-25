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

import java.sql.Timestamp;

import de.tu_berlin.dima.jhist.stat.Domain;

public class TimestampRange extends AbstractDomain<Timestamp> {

  private final long min;
  private final long max;

  public TimestampRange(final Timestamp min, final Timestamp max) {
    this.min = min.getTime();
    this.max = max.getTime();
  }

  @Override
  public Timestamp min() {
    return new Timestamp(min);
  }

  @Override
  public Timestamp max() {
    return new Timestamp(max);
  }

  @Override
  public Timestamp value(long ordinal) {
    return new Timestamp(ordinal + min);
  }

  @Override
  public long ordinal(Timestamp value) {
    return value.getTime() - min;
  }

  @Override
  public Domain<Timestamp> subDomain(Timestamp min, Timestamp max) {
    return new TimestampRange(min, max);
  }

}
