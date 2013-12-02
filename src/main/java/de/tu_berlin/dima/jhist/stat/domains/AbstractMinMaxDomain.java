package de.tu_berlin.dima.jhist.stat.domains;

import com.google.common.base.Objects;

/**
 * Base implementation for domains that are uniquely defined by a minimum and
 * maximum.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 */
public abstract class AbstractMinMaxDomain<T> extends AbstractDomain<T> {

  private final T min;
  private final T max;

  public AbstractMinMaxDomain(T min, T max) {
    this.min = min;
    this.max = max;
  }

  @Override
  public T min() {
    return min;
  }

  @Override
  public T max() {
    return max;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(min, max);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof AbstractDomain)) {
      return false;
    }
    AbstractMinMaxDomain<?> other = (AbstractMinMaxDomain<?>) obj;
    return Objects.equal(min, other.min) && Objects.equal(max, other.max);
  }

  @Override
  public String toString() {
    return "{" + min + " ... " + max + "}";
  }

}
