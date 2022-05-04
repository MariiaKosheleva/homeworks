package ua.kosheleva.hw15;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class MyList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;

    public int getIndex() {
        return index;
    }

    private int index;

    public void addEl(E value) {
        final MyNode<E> lastElem = tail;
        final MyNode<E> myNodeNew = new MyNode<>(value, null, lastElem);
        tail = myNodeNew;
        if (lastElem == null) {
            head = myNodeNew;
        } else {
            lastElem.setNext(myNodeNew);
        }
    }

    public Optional<E> getFromLast(E value) {
        index = 0;
        for (MyNode<E> i = tail; i != null; i = i.getPrev()) {
            index++;
            if (value.equals(i.getValue())) {
                return Optional.ofNullable(i.getValue());
            }
        }
        index = 0;
        return Optional.empty();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (MyNode<E> i = head; i != null; i = i.getNext()) {
            if (i != tail) {
                output.append(i.getValue()).append(" ");
            } else {
                output.append(i.getValue());
            }
        }
        return output + "]";
    }

    @Setter
    @Getter
    private static class MyNode<E> {
        private E value;
        private MyNode<E> next;
        private MyNode<E> prev;

        public MyNode(E value, MyNode<E> next, MyNode<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}



