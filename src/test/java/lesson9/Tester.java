package lesson9;

import lesson9.homework_9.DoubleLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tester {
    @Test
    public void testAdd()
    {
        DoubleLinkedList l = new DoubleLinkedList();
        l.addLast(10);
        l.addLast(20);
        assertEquals("[10,20]", l.toString());
    }
}
