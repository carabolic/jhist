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

import de.tu_berlin.dima.jhist.stat.BaseDomainTest;
import de.tu_berlin.dima.jhist.stat.Domain;
import de.tu_berlin.dima.jhist.stat.domains.TimestampRange;

public class TimestampRangeTest extends BaseDomainTest<Timestamp> {

  /*
   * 2013-10-01 00:00:00.000 (GMT/UTC + 01:00 hour)
   */
  private final Timestamp MINIMUM = new Timestamp(1380578400000L);

  /*
   * 2014-02-01 00:00:00.000 (GMT/UTC + 01:00 hour)
   */
  private final Timestamp MAXIMUM = new Timestamp(1391295600000L);

  @Override
  public Timestamp min() {
    return MINIMUM;
  }

  @Override
  public Timestamp max() {
    return MAXIMUM;
  }

  @Override
  public Domain<Timestamp> domainUnderTest() {
    return new TimestampRange(MINIMUM, MAXIMUM);
  }

}
