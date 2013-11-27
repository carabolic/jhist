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

import org.junit.Ignore;
import org.junit.Test;

import de.tu_berlin.dima.jhist.stat.Bucket;
import de.tu_berlin.dima.jhist.stat.Distribution;
import de.tu_berlin.dima.jhist.stat.Histogram;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public abstract class BaseHistogramTest<T> extends BaseDistributionTest<T> {

  /**
   * Returns a sample to be used for the tests.
   * @return
   */
  public abstract T[] sample();

  /**
   * Returns a filled histogram. This histogram is used in the unit tests.
   * @return Initialized and filled histogram.
   */
  public abstract Histogram<T> histogramUnderTest();

  @Override
  public Distribution<T> distributionUnderTest() {
    return histogramUnderTest();
  }

  @Ignore
  @Test
  public void printHistogram() {
    Histogram<T> histogram = histogramUnderTest();
    for (Bucket<T> bucket : histogram.buckets()) {
      System.out.format("%d <= x <= %d = %d\n", bucket.lowerBound(), bucket.upperBound(), bucket.frequency());
    }
  }

  @Test
  public void testBucketProbability() {
    Histogram<T> histogram = histogramUnderTest();
    double cumulativeProb = .0;
    for (Bucket<T> bucket : histogram.buckets()) {
      double prob = histogram.bucketProbability(bucket);
      cumulativeProb += prob;
      assertThat(prob, greaterThanOrEqualTo(0.0));
      assertThat(prob, lessThanOrEqualTo(1.0));
    }
    assertEquals(1.0, cumulativeProb, .0001);
  }

  @Test
  public void testTotal() {
    assertEquals(sample().length, histogramUnderTest().total());
  }


}
