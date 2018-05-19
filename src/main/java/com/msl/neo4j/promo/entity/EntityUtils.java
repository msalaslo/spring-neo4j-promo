package com.msl.neo4j.promo.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class EntityUtils {
	
	public static int getSize(Iterable<?> iterable) {
		int count = 0; 
		if (iterable instanceof Collection) {
	        count = ((Collection<?>) iterable).size();
	    } else {
	    	long longCount = StreamSupport.stream(iterable.spliterator(), false).count();
	    	count  = Math.toIntExact(longCount);
	    }
		return count;
	}
	
	public static <T> List<Relacionable> toRelacionable(final Stream<T> list) {
		return list.map(x -> (Relacionable) x).collect(Collectors.toList());
	}

	public static <T> List<Relacionable> toRelacionable(final List<T> list) {
		return list.parallelStream().map(x -> (Relacionable) x).collect(Collectors.toList());
	}

	public static <T> Iterable<Relacionable> toRelacionable(final Iterable<T> iterable) {
		return iterableToStream(iterable, true).map(x -> (Relacionable) x).collect(Collectors.toList());
	}
	
	public static <T> Iterable<Relacionable> toRelacionable(final Iterator<T> entities) {
		return iteratorToStream(entities, true).map(x -> (Relacionable) x).collect(Collectors.toList());
	}
	
	public static <T> List<RelacionableParent> toRelacionableParent(final Stream<T> list) {
		return list.map(x -> (RelacionableParent) x).collect(Collectors.toList());
	}
	
	public static <T> List<RelacionableParent> toRelacionableParent(final List<T> list) {
		return list.parallelStream().map(x -> (RelacionableParent) x).collect(Collectors.toList());
	}

	public static <T> Iterable<RelacionableParent> toRelacionableParent(final Iterable<T> iterable) {
		return iterableToStream(iterable, true).map(x -> (RelacionableParent) x).collect(Collectors.toList());
	}
	
	public static <T> Iterable<RelacionableParent> toRelacionableParent(final Iterator<T> entities) {
		return iteratorToStream(entities, true).map(x -> (RelacionableParent) x).collect(Collectors.toList());
	}
	
	public static <T> List<Promocionable> toPromocionable(final List<T> list) {
		return list.parallelStream().map(x -> (Promocionable) x).collect(Collectors.toList());
	}

	public static <T> Iterable<Promocionable> toPromocionable(final Iterable<T> iterable) {
		return iterableToStream(iterable, true).map(x -> (Promocionable) x).collect(Collectors.toList());
	}
	
	public static <T> Iterable<Promocionable> toPromocionable(final Iterator<T> entities) {
		return iteratorToStream(entities, true).map(x -> (Promocionable) x).collect(Collectors.toList());
	}
	
	public static <T> Stream<T> iterableToStream(final Iterable<T> iterable, final boolean parallell) {
		return StreamSupport.stream(iterable.spliterator(), parallell);
	}

	public static <T> Stream<T> iteratorToStream(final Iterator<T> iterator, final boolean parallell) {
		Iterable<T> iterable = () -> iterator;
		return StreamSupport.stream(iterable.spliterator(), parallell);
	}
}
