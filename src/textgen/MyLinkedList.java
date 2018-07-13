package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
	}
	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException("Element cannot be null");
		}
		else {
			size++;
		LLNode<E> dt = new LLNode<E>(element);
		//System.out.println(dt.data);
		tail = dt;
		//System.out.println(tail.prev);
		if(head == null||head.data==null) {
			head =dt;
		}
		else {
			LLNode<E> checker = head;
			//System.out.println(head.next);
			while(checker.next != null) {
				checker=checker.next;
			}
			checker.next = dt;
			dt.prev = checker;
	}}
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index>=size||index<0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> check = head;
		//we are starting from first node only
		//so for loop will start from 1
		//and we need to reach that index
		//so i<index+1
		for(int i=1;i<index+1;i++) {
			check = check.next;
		}
		//System.out.println(check.data);
		return check.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index>size||index<0) {
			throw new IndexOutOfBoundsException("Index>size for the list");
		}
		if(index == size) {
			add(element);
		}
		else {
			if(element == null){
				throw new NullPointerException("Element cannot be null");
			}
			size++;
		LLNode<E> dr = new LLNode<E>(element);
		LLNode<E> check = head;
		if(index==0) {
			LLNode<E> temp = head;
			head=dr;
			head.next=temp;
			temp.prev=dr;
		}
		else {
			//we are starting from first node only
			//so for loop will start from 1
			//and we need to reach one less than index
			//so i<index
		for(int i=1;i<index;i++) {
			check=check.next;
		}
		LLNode<E> temp=check.next;
		check.next=dr;
		dr.prev=check;
		dr.next=temp;
		temp.prev=dr;
		}
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index>=size||index<0) {
			throw new IndexOutOfBoundsException();
		}
		size--;
		LLNode<E> check = head;
		if(size ==0) {
			head=new LLNode<E>(null);
			tail=new LLNode<E>(null);
		}
		else {
		if(index==0) {
			head=head.next;
			head.prev=null;
		}
		else if(index == size) {
			check = tail;
			tail = tail.prev;
			tail.next=null;
		}
		else {
			//we are starting from first node only
			//so for loop will start from 1
			//and we need to reach that index
			//so i<index+1
			for(int i=1;i<index+1;i++) {
				check = check.next;
			}
			check.next.prev=check.prev;
			check.prev.next=check.next;
		}
		}
		return check.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index>=size||index<0) {
			throw new IndexOutOfBoundsException();
		}
		if(element == null){
			throw new NullPointerException("Element cannot be null");
		}
		LLNode<E> check = head;
		//we are starting from first node only
				//so for loop will start from 1
				//and we need to reach that index
				//so i<index+1
		for(int i=1;i<index+1;i++) {
			check = check.next;
		}
		E oldValue = check.data;
		check.data = element;
		return oldValue;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
