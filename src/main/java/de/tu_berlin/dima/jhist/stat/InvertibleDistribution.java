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
