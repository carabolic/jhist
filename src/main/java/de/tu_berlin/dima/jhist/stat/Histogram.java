package de.tu_berlin.dima.jhist.stat;

/**
 * This is the interface for all static histograms that approximate a discrete
 * probability distribution. A histogram is a set of disjoint
 * {@link Bucket buckets}. A histogram provides access to those buckets. Hence it
 * provides approximation for the distribution of the probability masses and
 * frequencies.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 */
public interface Histogram<T> extends Distribution<T> {

  /**
   * Returns the probability of the bucket.
   * @param bucket
   * @return
   */
  double bucketProbability(Bucket<T> bucket);

  /**
   * Checks if the histogram is empty. An empty histogram is a histogram that
   * has <code>p(X=x) = 0</code> for all <code>x</code>.
   * @return <code>True</code> if the histogram is empty, <code>false</code>
   *   otherwise.
   */
  boolean isEmpty();

  /**
   * Returns the total amount of observations, samples or data points.
   * @return total frequency of the histogram
   */
  long total();

  /**
   * Calculates the number of buckets.
   * @return Number of buckets.
   */
  int numberOfBuckets();

  /**
   * Retrieve the bucket that contains the value.
   * @param value
   * @return The bucket containing the value
   * @see {@link Bucket}
   */
  Bucket<T> bucketOf(T value);

  /**
   * Retrieves the serial bucket number for the value.
   * @param value
   * @return The number <code>n</code> of the bucket, where
   *   <code>0 &leq; n &leq; {@link #numberOfBuckets()}</code>
   */
  int bucketNumber(T value);

  /**
   * Returns an iterable of the buckets.
   * @return
   */
  Iterable<Bucket<T>> buckets();

}
