package de.tu_berlin.dima.jhist.stat;

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
