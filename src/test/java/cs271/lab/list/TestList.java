package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestList {

  private List<Integer> list;

  @Before
  public void setUp() throws Exception {
    list = new ArrayList<Integer>();
  }

  @After
  public void tearDown() throws Exception {
    list = null;
  }

  @Test
  public void testSizeEmpty() {
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
    try {
      list.get(0);
      fail("there should not be any items in the list");
    } catch (Exception ex) {
    }
  }

  @Test
  public void testSizeNonEmpty() {
    list.add(77);
    assertFalse(list.isEmpty());
    assertEquals(1, list.size());
    assertEquals(77, list.get(0).intValue());
  }

  @Test
  public void testContains() {
    assertFalse(list.contains(77));
    list.add(77);
    assertTrue(list.contains(77));
  }

  @Test
  public void testAddMultiple() {
    list.add(77);
    list.add(77);
    list.add(77);
    // Fixed assertions
    assertEquals(3, list.size());
    assertEquals(0, list.indexOf(77));
    assertEquals(77, list.get(1).intValue());
    assertEquals(2, list.lastIndexOf(77));
  }

  @Test
  public void testAddMultiple2() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // Fixed assertions
    assertEquals(7, list.size());
    assertEquals(1, list.indexOf(77));
    assertEquals(5, list.lastIndexOf(77));
    assertEquals(44, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
    assertEquals(List.of(33, 77, 44, 77, 55, 77, 66), list);
  }

  @Test
  public void testRemoveObject() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);

    list.remove(5); // removes 3rd occurrence of 77
    list.remove(Integer.valueOf(77)); // removes first 77 found

    assertEquals(List.of(33, 44, 77, 55, 66), list);
  }

  @Test
  public void testContainsAll() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    assertTrue(list.containsAll(List.of(33, 44, 55, 66, 77)));
    assertFalse(list.containsAll(List.of(11, 22, 33)));
  }

  @Test
  public void testAddAll() {
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    assertEquals(7, list.size());
    assertEquals(33, list.get(0).intValue());
    assertEquals(77, list.get(1).intValue());
    assertEquals(44, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
    assertEquals(55, list.get(4).intValue());
    assertEquals(77, list.get(5).intValue());
    assertEquals(66, list.get(6).intValue());
  }

  @Test
  public void testRemoveAll() {
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    list.removeAll(List.of(33, 44, 55, 66));
    assertEquals(3, list.size());
    assertEquals(List.of(77, 77, 77), list);
  }

  @Test
  public void testRetainAll() {
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    list.retainAll(List.of(77));
    assertEquals(3, list.size());
    assertEquals(List.of(77, 77, 77), list);
  }

  @Test
  public void testSet() {
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    list.set(1, 99);
    list.set(3, 99);
    list.set(5, 99);
    assertEquals(7, list.size());
    assertEquals(33, list.get(0).intValue());
    assertEquals(99, list.get(1).intValue());
    assertEquals(44, list.get(2).intValue());
    assertEquals(99, list.get(3).intValue());
    assertEquals(55, list.get(4).intValue());
    assertEquals(99, list.get(5).intValue());
    assertEquals(66, list.get(6).intValue());
  }

  @Test
  public void testSubList() {
    list.addAll(List.of(33, 77, 44, 77, 55, 77, 66));
    assertEquals(List.of(44, 77, 55), list.subList(2, 5));
  }
}
