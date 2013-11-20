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

import de.tu_berlin.dima.jhist.stat.distributions.UniformDistribution;

/**
 * This interface is an extension the the {@link Distribution} interface. All
 * discrete probability distributions that are invertible should preferably 
 * implement this interface rather that {@link Distribution}.
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 * @see {@link Distribution} and {@link UniformDistribution}
 */
public interface InvertibleDistribution<T> extends Distribution<T> {

  /**
   * Returns the largest value, such that the
   * {@link #cumulativeProbability(Object)} is less or equal to the given
   * cumulative probability.
   * @param cumulativeProbability
   * @return
   */
  T invertedCumulativeProbability(double cumulativeProbability);

}
