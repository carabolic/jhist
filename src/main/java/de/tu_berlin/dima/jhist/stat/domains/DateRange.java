/*******************************************************************************
 * Copyright 2015 DIMA Research Group, TU Berlin (http://www.dima.tu-berlin.de)
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

import java.sql.Date;
import java.time.temporal.ChronoUnit;

import de.tu_berlin.dima.jhist.stat.Domain;

/**
 * This class is a {@link Domain} implementation used to represent {@link java.sql.Date} ranges.
 * An date range is given by a minimum and maximum date (inclusive). The
 * cardinality of a date range is given by the days between <code>min</code> and <code>max</code>.
 *
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 */
public class DateRange extends AbstractDomain<Date> {

  private final long min;
  private final long max;

  public DateRange(final Date min, final Date max) {
    this.min = min.getTime();
    this.max = max.getTime();
  }

  @Override
  public Date min() {
    return new Date(min);
  }

  @Override
  public Date max() {
    return new Date(max);
  }

  @Override
  public Date value(long ordinal) {
    return Date.valueOf(min().toLocalDate().plusDays(ordinal));
  }

  @Override
  public long ordinal(Date value) {
    return ChronoUnit.DAYS.between(min().toLocalDate(), value.toLocalDate());
  }

  @Override
  public Domain<Date> subDomain(Date min, Date max) {
    return new DateRange(min, max);
  }

}
