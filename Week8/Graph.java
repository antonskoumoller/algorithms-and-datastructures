package Week8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Graph {
    
    private final int V;
    private int E; 
    private Bag<Edge>[] adj;

    public Graph() throws FileNotFoundException {
        
        File file = new File("Week8\\file.txt");
        Scanner sc = new Scanner(file);
        V = sc.nextInt();
        E = sc.nextInt();

        
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }

        for (int i = 0; i < E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            int isConflict = sc.nextInt();
            addEdge(v, w, isConflict);
        }
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public void addEdge(int v, int w, int isConflict) {
        
        adj[v].add(new Edge(w, isConflict));
        adj[w].add(new Edge(v, isConflict));
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }
}

class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

