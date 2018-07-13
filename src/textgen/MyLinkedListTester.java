/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		// TODO: Add more tests here
		assertEquals("Remove: check elements are correct",longerList.get(1),longerList.remove(1));
		//System.out.println(shortList.remove(shortList.size()-1));
		assertEquals("Remove: last element",shortList.get(shortList.size()-1),shortList.remove(shortList.size()-1));
		assertEquals("Remove: check last element is correct ", shortList.get(0), shortList.get(shortList.size()-1));
		assertEquals("Remove: check size is correct ", 1, shortList.size());
		shortList.remove(0);
		try {
			shortList.remove(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		
		shortList.add("Hi");
		assertEquals("Check last", "Hi", shortList.get(shortList.size()-1));
		assertEquals("Check last", (Integer)9, longerList.get(LONG_LIST_LENGTH-1));
		assertEquals("Check last", (Integer)42, list1.get(list1.size()-1));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Check size for longerList",10,longerList.size());
		assertEquals("Check size for shortList",2,shortList.size());
		assertEquals("Check size for emptyList",0,emptyList.size());
		assertEquals("Check size for list1",3,list1.size());
		try {
			shortList.add(null);
			fail("Check null pointer exception");
		}
		catch (NullPointerException e) {
		
		}
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		shortList.add(0,"i");
		//System.out.println(shortList.get(0));
		assertEquals("Check element added at 0 index", "i", shortList.get(0));
		longerList.add(2, 10);
		assertEquals("Check element added at index = 2", (Integer)10, longerList.get(2));
		list1.add(3, 5);
		assertEquals("Check element added at index = 3", (Integer)5, list1.get(3));
		assertEquals("Check size for longerList",11,longerList.size());
		longerList.add(11, 47);
		assertEquals("Check last element",(Integer)47,longerList.get(11));
		assertEquals("Check size for longerList",12,longerList.size());
		//System.out.println(shortList.get(0)+ " " + longerList.get(2) + " " + list1.get(3));
		try {
			shortList.add(-1, "a");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.add(4, "a");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.add(2,null);
			fail("Check null pointer exception");
		}
		catch (NullPointerException e) {
		
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		//System.out.println(shortList.set(1, "yo")+ " " + shortList.get(1));
		String a=shortList.set(1, "Hi");
		assertEquals("Check set value","B",a);
		assertEquals("Check changed value","Hi", shortList.get(1));
		assertEquals("Check set value",longerList.get(LONG_LIST_LENGTH-1),longerList.set(LONG_LIST_LENGTH-1, 24));
		assertEquals("Check changed value",(Integer)24, longerList.get(LONG_LIST_LENGTH-1));
		try {
			shortList.set(-1, "a");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(5,"last element");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(0,null);
			fail("Check null pointer exception");
		}
		catch (NullPointerException e) {
		
		}
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
