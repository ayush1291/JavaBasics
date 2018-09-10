package com.multithreading.pool.custom;

import java.util.*;

class CustomBlockingQueue<E> implements ICustomBlockingQueue<E> {

	private List<E> queue;
	private int maxSize; // maximum number of elements queue can hold at a time.

	public CustomBlockingQueue(int maxSize) {
		this.maxSize = maxSize;
		queue = new LinkedList<E>();
	}

	/**
	 * Inserts the specified element into this queue only if space is available
	 * else waits for space to become available. After inserting element it
	 * notifies all waiting threads.
	 */
	public void put(E item) throws InterruptedException {

		// check space is available or not.
		synchronized (this) {
			if (queue.size() == maxSize) {
				wait();
			}
			queue.add(item);
			notify();
		}

		// space is available, insert element and notify all waiting threads.

	}

	/**
	 * Retrieves and removes the head of this queue only if elements are
	 * available else waits for element to become available. After removing
	 * element it notifies all waiting threads.
	 */
	public synchronized E take() throws InterruptedException {

		// waits element is available or not.
		 {
			if (queue.size() == 0) {
				System.out.println("No task available---so wait");
				wait();
			}
//			notifyAll();
		}

		System.out.println("Task available---so notify all ");
		// element is available, remove element and notify all waiting threads.
		return queue.remove(0);

	}

	/**
	 * Returns size of LinkedBlockingQueueCustom.
	 */
	public synchronized int size() {
		return queue.size();
	}

}
