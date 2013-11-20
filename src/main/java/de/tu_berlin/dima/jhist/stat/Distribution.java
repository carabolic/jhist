package de.tu_berlin.dima.jhist.stat;

/**
 * This interface represents a discrete distribution. Provides methods to
 * calculate the probability and cumulative probability.
 * <br />
 * All implementing classes have to guarantee that the methods
 * {@link #probability(Object)} and {@link #cumulativeProbability(Object)} are
 * defined for all values generated by {@link #values()}.
 * 
 * @see {@link Domain}
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 */
public interface Distribution<T> {

  /**
   * Returns the probability mass of the value.
   * <br />
   * The following rules need to be satisfied for all probabilities <code>p</code>:
   * <ul>
   *   <li><code>0 &leq; p &leq; 1<code></li>
   *   <li><code>p_0 + p_1 + ... + p_n = 1</code></li>
   * </ul>
   * @param value
   * @return
   */
  double probability(T value);

  /**
   * Returns the cumulative probability mass of the value.
   * <br />
   * The following conditions hold for all cumulative probabilities
   * <code>F</code>:
   * <ul>
   *   <li><code>0 &leq; F &leq; 1</code></li>
   *   <li><code>F(max) = 1</code></li>
   *   <li><code>F(min) = p(min)</code></li>
   * </ul>
   * @param value
   * @return
   */
  double cumulativeProbability(T value);

  /**
   * Returns all values that are covered by this domain in order.
   * @return
   */
  Iterable<T> values();

}
