package stream.findVogals.factory.impl;

import java.util.Iterator;

import stream.findVogals.factory.Stream;

public class CharStream<T> implements Stream, Iterable<T>{	
	private final java.util.stream.Stream<T> stream;
	
	public CharStream(java.util.stream.Stream<T> stream) {
	    this.stream = stream;
	}
	
	public java.util.stream.Stream<T> getStream() {
		return stream;
	}
	
	@Override
	public char getNext() {
		return (char) stream.iterator().next();
	}

	@Override
	public boolean hasNext() {
		return stream.iterator().hasNext();
	}

	@Override
	public Iterator<T> iterator() {
		return new CharStreamInterator<>(stream);
	}
}
