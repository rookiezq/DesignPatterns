package com.rookied.dp.iterator;

/**
 * @author zhangqiang
 * @date 2021/4/30
 */
public class LinkList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int size = 0;

    public void add(E e) {
        Node<E> node = new Node<>(e);
        node.next = null;

        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public Iterator<E> iterator() {
        return new LinkListIterator();
    }

    private class LinkListIterator implements Iterator<E> {
        Node<E> node = head;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public E next() {
            E tmp = node.vlaue;
            node = node.next;
            return tmp;
        }
    }

    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class Node<T> {
    T vlaue;
    Node<T> next;

    public Node(T vlaue) {
        this.vlaue = vlaue;
    }
}

interface Iterator<E> {
    boolean hasNext();

    E next();
}
