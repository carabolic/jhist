package de.tu_berlin.dima.jhist.stat;

import de.tu_berlin.dima.jhist.stat.Histogram;
import de.tu_berlin.dima.jhist.stat.DynamicHistogram;

public abstract class BaseMutableHistogramTest<T> extends BaseHistogramTest<T> {

  /**
   * Returns a new empty instance of a mutable histogram. Resembles a factory
   * method to create the mutable histogram instances under test.
   * @return New and empty mutable histogram.
   */
  public abstract DynamicHistogram<T> getMutableHistogramInstance();

  @Override
  public Histogram<T> histogramUnderTest() {
    DynamicHistogram<T> histogram = getMutableHistogramInstance();
    for (T value : sample()) {
      histogram.add(value);
    }
    return histogram;
  }

}
