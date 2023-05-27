package blatt7.Aufgabe1;

import java.util.Enumeration;

public interface Set <E>{
public boolean add(E element);
public boolean test(E element);
public boolean remove(E element);
public Enumeration<E> elements();
}
