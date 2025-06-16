COMP 313/413 Project 2 Report

TestList.java and TestIterator.java

	TODO also try with a LinkedList - does it make any difference?

	Answer:
	Using a LinkedList instead of an ArrayList can make a performance difference depending on the operation.
	LinkedList can be faster for insertions and removals at the beginning or middle of the list,
	while ArrayList is faster for random access due to its underlying array structure. 
	In this lab, since we mostly accessed items by index or iterated linearly, ArrayList offered better performance overall.

TestList.java

	testRemoveObject()

		list.remove(5); // what does this method do?

			Answer:
			This removes the element at index 5 from the list. So in this case, it removes the third occurrence of 77.

		list.remove(Integer.valueOf(77)); // what does this one do?

			Answer:
			This removes the first occurrence of the value 77 from the list using object-based removal.

TestIterator.java

	testRemove()

		i.remove(); // what happens if you use list.remove(77)?

			Answer:
			Using list.remove(77) inside a loop causes a ConcurrentModificationException because it modifies the list
			while it's being iterated over. Instead, iterator.remove() removes the current element during the iteration.

TestPerformance.java

	State how many times the tests were executed for each SIZE (10, 100, 1000 and 10000)
	to get the running time in milliseconds and how the test running times were recorded.

	Execution count: REPS = 1,000,000
	Timing was recorded using System.currentTimeMillis() right before and after each test loop.

	SIZE 10
								  #1     #2     #3
        testArrayListAddRemove:  6 ms   6 ms   7 ms
        testLinkedListAddRemove: 9 ms   8 ms   9 ms
		testArrayListAccess:     2 ms   2 ms   2 ms
        testLinkedListAccess:    4 ms   5 ms   4 ms

	SIZE 100
								  #1     #2     #3
        testArrayListAddRemove:  51 ms  53 ms  52 ms
        testLinkedListAddRemove: 58 ms  59 ms  58 ms
		testArrayListAccess:     12 ms  13 ms  12 ms
        testLinkedListAccess:    24 ms  25 ms  23 ms

	SIZE 1000
								  #1     #2     #3
        testArrayListAddRemove:  605 ms 610 ms 615 ms
        testLinkedListAddRemove: 345 ms 355 ms 350 ms
		testArrayListAccess:     81 ms  84 ms  83 ms
        testLinkedListAccess:    215 ms 220 ms 218 ms

	SIZE 10000
								  #1     #2     #3
        testArrayListAddRemove:  6900 ms 6950 ms 6980 ms
        testLinkedListAddRemove: 2100 ms 2150 ms 2120 ms
		testArrayListAccess:     950 ms  940 ms  955 ms
        testLinkedListAccess:    3700 ms 3750 ms 3725 ms

	listAccess - which type of List is better to use, and why?

		Answer:
		ArrayList is better for access-heavy operations because it gives constant-time access by index (O(1)),
		while LinkedList has to traverse from the head (O(n)). This was seen from the faster access times for ArrayList at all sizes.

	listAddRemove - which type of List is better to use, and why?

		Answer:
		LinkedList is better for frequent insertions and removals at the beginning or middle of the list 
		because it doesn't require shifting elements like ArrayList does but the difference could be seen only at larger sizes like 10000. And for small sizes ArrayList still performed fine.

