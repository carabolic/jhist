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

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import de.tu_berlin.dima.jhist.stat.Domain;

public abstract class BaseDomainTest<T> {

  private Domain<T> domain;

  public abstract T min();

  public abstract T max();

  public abstract Domain<T> domainUnderTest();

  @Before
  public void setUp() {
    this.domain = domainUnderTest();
  }

  @After
  public void tearDown() {
    this.domain = null;
  }

  @Test
  @Ignore
  public void printCharacteristics() {
    System.out.format("%s from %s to %s with cardinality %s\n",
        domain.getClass().getSimpleName(),
        domain.min(), domain.max(), domain.cardinality());
  }

  @Test
  public void testMin() {
    assertEquals(min(), domain.min());
  }

  @Test
  public void testMax() {
    assertEquals(max(), domain.max());
  }

  @Test
  public void testValue() {
    assertEquals(domain.min(), domain.value(domain.ordinal(domain.min())));
    assertEquals(domain.max(), domain.value(domain.ordinal(domain.max())));
  }

  @Test
  public void testOrdinal() {
    T min = domain.min();
    T max = domain.max();
    assertThat(domain.ordinal(min), lessThanOrEqualTo(domain.ordinal(max)));
    assertEquals(0L, domain.ordinal(min));
    assertEquals(domain.cardinality() - 1, domain.ordinal(max));
  }

  @Test
  public void testCardinality() {
    assertThat(domain.cardinality(), greaterThanOrEqualTo(1L));
    assertEquals(domain.ordinal(domain.max()) + 1, domain.cardinality());
  }

  @Test
  public void testContains() {
    T min = domain.min();
    T max = domain.max();
    assertTrue(domain.contains(min));
    assertTrue(domain.contains(max));
  }

  @Test
  public void testIterator() {
    // assume that cardinality is not too big (to decrease test runtime)
    assumeThat(domain.cardinality(), lessThanOrEqualTo(1000000L));
    Iterator<T> domIter = domain.iterator();
    long numElements = 0L;
    while (domIter.hasNext() && domIter.next() != null && (numElements += 1) > 0L);
    assertEquals(domain.cardinality(), numElements);
  }

}
