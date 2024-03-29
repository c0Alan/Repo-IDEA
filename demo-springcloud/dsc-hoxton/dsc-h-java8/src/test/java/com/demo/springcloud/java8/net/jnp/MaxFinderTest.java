package com.demo.springcloud.java8.net.jnp;

import static org.junit.Assert.*;

import java.util.concurrent.ExecutionException;

import com.demo.springcloud.java8.net.jnp4examples.MultithreadedMaxFinder;
import org.junit.Test;


public class MaxFinderTest {

  @Test
  public void testOddElement() throws InterruptedException, ExecutionException {
    int[] data = {1, 2, 56, -98, 10};
    assertEquals(56, MultithreadedMaxFinder.max(data));
  }
  
  @Test
  public void testEvenElement() throws InterruptedException, ExecutionException {
    int[] data = {1, 2, 56, 23, -98, 10};
    assertEquals(56, MultithreadedMaxFinder.max(data));
  }
  
  @Test
  public void testEnd() throws InterruptedException, ExecutionException {
    int[] data = {1, 2, 23, -98, 10, 56};
    assertEquals(56, MultithreadedMaxFinder.max(data));
  }
  
  @Test
  public void testBeginning() throws InterruptedException, ExecutionException {
    int[] data = {56, 1, 2, 23, -98, 10, 5};
    assertEquals(56, MultithreadedMaxFinder.max(data));
  }


  @Test
  public void testOneElement() throws InterruptedException, ExecutionException {
    int[] data = {56};
    assertEquals(56, MultithreadedMaxFinder.max(data));
  }
  
  @Test
  public void testOddElementAfterSplit() throws InterruptedException, ExecutionException {
    int[] data = {1, 2, -98, 56, 10};
    assertEquals(56, MultithreadedMaxFinder.max(data));
  }
  
  
}
