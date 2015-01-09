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

import java.sql.Date;

import de.tu_berlin.dima.jhist.stat.BaseDomainTest;
import de.tu_berlin.dima.jhist.stat.Domain;

public class DateRangeTest extends BaseDomainTest<Date> {

  /*
   * 2013-10-01 (GMT/UTC + 01:00 hour)
   */
  private static final Date MINIMUM = new Date(1380578400000L);

  /*
   * 2014-02-01 (GMT/UTC + 01:00 hour)
   */
  private static final Date MAXIMUM = new Date(1391295600000L);

  @Override
  public Date min() {
    return MINIMUM;
  }

  @Override
  public Date max() {
    return MAXIMUM;
  }

  @Override
  public Domain<Date> domainUnderTest() {
    return new DateRange(MINIMUM, MAXIMUM);
  }

}
