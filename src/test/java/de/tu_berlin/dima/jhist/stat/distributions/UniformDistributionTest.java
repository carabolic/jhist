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
package de.tu_berlin.dima.jhist.stat.distributions;

import de.tu_berlin.dima.jhist.stat.BaseDistributionTest;
import de.tu_berlin.dima.jhist.stat.Distribution;
import de.tu_berlin.dima.jhist.stat.Domain;
import de.tu_berlin.dima.jhist.stat.domains.IntegerRange;

public class UniformDistributionTest extends BaseDistributionTest<Integer> {

  private static final Domain<Integer> domain = new IntegerRange(1, 10);
  private static final Distribution<Integer> distribution = new UniformDistribution<Integer>(domain);

  @Override
  public Domain<Integer> domainUnderTest() {
    return domain;
  }

  @Override
  public Distribution<Integer> distributionUnderTest() {
    return distribution;
  }

}
