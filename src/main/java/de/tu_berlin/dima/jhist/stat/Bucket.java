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

/**
 * This class represents a bucket or bin. That is an interval combined with a
 * frequency. An interval is represent by a {@link Domain} object. Depending on
 * the used domain the interval might be open, closed, or mixed.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 */
public class Bucket<T> {

  private final Domain<T> interval;
  private final long frequency;

  /**
   * Constructs new bucket.
   * @param interval
   * @param frequency
   */
  public Bucket(final Domain<T> interval, final long frequency) {
    this.interval = interval;
    this.frequency = frequency;
  }

  /**
   * Returns the lowest value within the bucket.
   * @return
   */
  public T lowerBound() {
    return interval.min();
  }

  /**
   * Returns the highest value within the bucket.
   * @return
   */
  public T upperBound() {
    return interval.max();
  }

  /**
   * Returns the frequency of the bucket.
   * @return
   */
  public long frequency() {
    return frequency;
  }

  /**
   * Checks whether the value is contained by the bucket or not.
   * @param value
   * @return
   */
  public boolean contains(T value) {
    return interval.contains(value);
  }

  /**
   * Returns the cardinality of the bucket, i.e. the amount of different (unique)
   * values represented by this bucket.
   * @return
   */
  public long cardinality() {
    return interval.cardinality();
  }

}
