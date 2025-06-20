package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  private final int SIZE = 100;

  private final int REPS = 1000000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    long start = System.currentTimeMillis();
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
    long end = System.currentTimeMillis();
    System.out.println("LinkedList add/remove took: " + (end - start) + " ms");
  }

  @Test
  public void testArrayListAddRemove() {
    long start = System.currentTimeMillis();
    for (var r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
    long end = System.currentTimeMillis();
    System.out.println("ArrayList add/remove took: " + (end - start) + " ms");
  }

  @Test
  public void testLinkedListAccess() {
    long start = System.currentTimeMillis();
    long sum = 0;
    for (var r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
    long end = System.currentTimeMillis();
    System.out.println("LinkedList access took: " + (end - start) + " ms");
  }

  @Test
  public void testArrayListAccess() {
    long start = System.currentTimeMillis();
    long sum = 0;
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
    long end = System.currentTimeMillis();
    System.out.println("ArrayList access took: " + (end - start) + " ms");
  }
  }