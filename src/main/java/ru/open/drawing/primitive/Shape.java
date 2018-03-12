package ru.open.drawing.primitive;

import java.util.Iterator;
import java.util.List;

/**
 * @author Ivan Zemlyanskiy
 */
public class Shape implements Iterable<Pixel>{


    private Iterable<Pixel> iterable;

    public Shape(Iterable<Pixel> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<Pixel> iterator() {
        return iterable.iterator();
    }

    public void getPixelsAsList() {

    }

}
