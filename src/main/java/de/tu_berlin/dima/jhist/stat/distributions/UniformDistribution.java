/*******************************************************************************
 * Copyright 2013 - 2014 DIMA Research Group, TU Berlin (http://www.dima.tu-berlin.de)
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

import de.tu_berlin.dima.jhist.stat.Domain;
import de.tu_berlin.dima.jhist.stat.InvertibleDistribution;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * This class is a representation of the uniform distribution. That is, all
 * values are equally likely. It is furthermore assumed that the values are
 * evenly spread across the domain. Therefore the probability for all values in
 * domain <code>D</code> is given by <code> 1 / N</code>, where the cardinality
 * <code>N</code> is given by <code>| D | = N</code>.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 */
public class UniformDistribution<T> implements InvertibleDistribution<T> {

  private final Domain<T> domain;

  /**
   * Creates a new uniform distribution over the domain.
   * @param domain The domain representing the possible values for the distribution.
   */
  public UniformDistribution(final Domain<T> domain) {
    this.domain = domain;
  }

  /**
   * {@inheritDoc}
   * Runs in constant <code>O(1)</code> time.
   */
  @Override
  public double probability(T value) {
    return 1.0 / domain.cardinality();
  }

  /**
   * {@inheritDoc}
   * Runs in constant <code>O(1)</code> time.
   */
  @Override
  public double cumulativeProbability(T value) {
    Domain<T> interval = domain.subDomain(domain.min(), value);
    return (double) interval.cardinality() / domain.cardinality();
  }

  /**
   * {@inheritDoc}
   * Runs in constant <code>O(1)</code> time.
   */
  @Override
  public T invertedCumulativeProbability(double cumulativeProbability) {
    checkArgument(0 < cumulativeProbability && cumulativeProbability <= 1.0);
    long card = domain.cardinality();
    long min = domain.ordinal(domain.min());
    long ordinal = (long) Math.ceil(cumulativeProbability * card) + min - 1;
    return domain.value(ordinal);
  }

  @Override
  public Iterable<T> values() {
    return domain;
  }

}
