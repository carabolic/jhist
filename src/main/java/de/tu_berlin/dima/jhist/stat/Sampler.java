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

import java.util.Random;

/**
 * This class is used to sample from given distributions. Therefore it uses
 * {@link Random} as a pseudo random number generator.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 * @see {@link Distribution}, {@link InvertibleDistribution} and
 *   {@link Histogram}
 */
public class Sampler<T> {

  public final Random rand;

  public Sampler() {
    this.rand = new Random();
  }

  public Sampler(long seed) {
    this.rand = new Random(seed);
  }

  /**
   * Inverse transform sampling.
   * <br />
   * Runs in <code>O(E(n))</code> time.
   * @param distribution
   * @return
   */
  public T sample(Distribution<T> distribution) {
    double prob = rand.nextDouble();
    double cumProb = .0;
    T min = null;
    for (T value : distribution.values()) {
      min = (min == null) ? value : min;
      cumProb += distribution.probability(value);
      if (cumProb >= prob) {
        return value;
      }
    }
    return min;
  }

  /**
   * Sampling using the inverse cumulative probability function.
   * <br />
   * Runs in <code>O(1)</code> time.
   * @param distribution
   * @return
   */
  public T sample(InvertibleDistribution<T> distribution) {
    double prob = rand.nextDouble();
    return distribution.invertedCumulativeProbability(prob);
  }

}
