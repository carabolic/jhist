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
package de.tu_berlin.dima.jhist.stat.domains;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;

import de.tu_berlin.dima.jhist.stat.Domain;

/**
 * Implementation of the {@link Domain} interface for Enums. The order of the
 * enumeration is given by the order its values are specified in the enum
 * definition.
 * 
 * @author Christoph Brücke (christoph.bruecke@campus.tu-berlin.de)
 *
 * @param <T>
 */
public class EnumDomain<T extends Enum<T>> extends AbstractDomain<T> {

  private final T[] values;
 
  @SuppressWarnings("unchecked")
  public EnumDomain(final Enum<T> enumeration) {
    this.values = (T[]) enumeration.getClass().getEnumConstants();
  }

  public EnumDomain(final Class<T> clazz) {
    checkArgument(clazz.isEnum());
    this.values = clazz.getEnumConstants();
  }

  public EnumDomain(final Enum<T> min, final Enum<T> max) {
    int first = min.ordinal();
    int last = max.ordinal();
    @SuppressWarnings("unchecked")
    T[] allVals = (T[]) min.getClass().getEnumConstants();
    this.values = Arrays.copyOfRange(allVals, first, last + 1);
  }

  @Override
  public T min() {
    return values[0];
  }

  @Override
  public T max() {
    return values[values.length - 1];
  }

  @Override
  public T value(long ordinal) {
    return values[(int) ordinal];
  }

  @Override
  public long ordinal(T value) {
    return value.ordinal();
  }

  @Override
  public long cardinality() {
    return values.length;
  }

  @Override
  public Domain<T> subDomain(T min, T max) {
    return new EnumDomain<T>(min, max);
  }

}
