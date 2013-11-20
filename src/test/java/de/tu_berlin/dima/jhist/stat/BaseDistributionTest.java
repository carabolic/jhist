package de.tu_berlin.dima.jhist.stat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import de.tu_berlin.dima.jhist.stat.Distribution;
import de.tu_berlin.dima.jhist.stat.Domain;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public abstract class BaseDistributionTest<T> {

  private static final double EXPECTED_ERROR = .1;

  private Domain<T> domain;
  private Distribution<T> distribution;

  public abstract Domain<T> domainUnderTest();

  public abstract Distribution<T> distributionUnderTest();

  @Before
  public void setUpBase() {
    domain = domainUnderTest();
    distribution = distributionUnderTest();
  }

  @After
  public void tearDownBase() {
    domain = null;
    distribution = null;
  }

  @Test
  @Ignore
  public void printPdf() {
    for (T value : domain) {
      System.out.format(
          "P(X=%s) = %f\tP(X<=%s) = %f\n",
          value.toString(), distribution.probability(value),
          value.toString(), distribution.cumulativeProbability(value));
    }
  }

  @Test
  public void testProbability() {
    double summedProb = .0;
    for (T value : domain) {
      double p = distribution.probability(value);
      summedProb += p;
      // check for non-negativity
      assertThat(p, greaterThanOrEqualTo(0.0));
      assertThat(p, lessThanOrEqualTo(1.0));
    }
    assertEquals(1.0, summedProb, EXPECTED_ERROR);
  }

  @Test
  public void testCumulativeProbability() {
    T min = domain.min();
    T max = domain.max();
    assertEquals(
        distribution.probability(min),
        distribution.cumulativeProbability(min),
        EXPECTED_ERROR);
    assertEquals(
        1.0,
        distribution.cumulativeProbability(max),
        EXPECTED_ERROR);
  }

}
