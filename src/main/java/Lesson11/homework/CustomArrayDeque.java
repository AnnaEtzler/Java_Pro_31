package Lesson11.homework;

import java.util.Arrays;

public class CustomArrayDeque implements CustomDeque{

    private int [] sorce;
    private int size = 0;
    private int firstElement = 0;

    private static final int CAPACITY = 4;

    public CustomArrayDeque(){
        sorce = new int[CAPACITY];

    }


    @Override
    public void addFirst(int i) {
        if(size == sorce.length){
            increaseCapacity();
        }

        firstElement =  (firstElement-1 +sorce.length )% sorce.length;

      //  if(firstElement == 0){
        //    firstElement = sorce.length -1;
        //} else {
          //  firstElement = firstElement - 1;
        //}
        sorce[firstElement] = i;
        size++;

    }

    @Override
    public String toString() {
        StringBuilder  b = new StringBuilder();
        b.append("[");
        for(int i = 0; i < size; i++)
        {
            b.append(sorce[(firstElement + i)% sorce.length]);
            if(i < size - 1)
                b.append(", ");
        }
        b.append("]");
        return b.toString();
//        return Arrays.toString(source);
    }

    private void increaseCapacity() {
        int [] newSorce = new int[sorce.length*2];
        int j = 0;
        for(int i = firstElement; i < sorce.length; i++){
            newSorce[j++] = sorce[i];
        }
        for (int i = 0; i < firstElement; i++){
            newSorce[j++] = sorce[i];
        }
        firstElement = 0;
        sorce = newSorce;
    }

    @Override
    public int getFirst() {
        if(size == 0){
            throw new IndexOutOfBoundsException();

        }
        return sorce[firstElement];
    }

    @Override
    public int removeFirst() {
        if(size == 0){
            throw new IndexOutOfBoundsException();
        }
        int el = sorce[firstElement];
        firstElement = (firstElement + 1) % sorce.length;
        size--;

        return el;
    }

    @Override
    public void addLast(int i) {
        if(size == sorce.length)
            increaseCapacity();
        sorce[(firstElement + size) % sorce.length] = i;
        size++;

    }

    @Override
    public int getLast() {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        return sorce[(size - 1 + firstElement) % sorce.length];
    }

    @Override
    public int removeLast() {
        if(size == 0)
            throw new IndexOutOfBoundsException();
        int r = sorce[(size - 1 + firstElement) % sorce.length];
        size--;
        return r;
    }

    @Override
    public int size() {
        return size;
    }
}
