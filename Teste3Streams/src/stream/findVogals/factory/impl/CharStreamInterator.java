package stream.findVogals.factory.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.stream.Stream;

public class CharStreamInterator<T> implements Iterator<T> {
	
	private final Spliterator<T> spliterator;
	private boolean nextIsKnown = false;
	private T next = null;

	public CharStreamInterator(Stream<T> stream) {
		this.spliterator = stream.spliterator();
	}

	@Override
	public boolean hasNext() {
		if (nextIsKnown)
	        return true;
	    return spliterator.tryAdvance(t -> {next = t; nextIsKnown = true;});
	}

	@Override
	public T next() {
		if (nextIsKnown) {
	        return resetAndReturnNext();
	    }
	    if (!hasNext())
	        throw new NoSuchElementException();
	    return resetAndReturnNext();
	}
	
	private T resetAndReturnNext() {
		T result = next;
	    nextIsKnown = false;
	    next = null;
	    return result;
	}

}
