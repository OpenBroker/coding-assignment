package ru.open.drawing.primitive;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * @author Ivan Zemlyanskiy
 */
@Value
@AllArgsConstructor
public class Pixel implements Comparable<Pixel> {
    Point point;
    Colour colour;

    public Pixel(int x, int y, char value) {
        this.point = new Point(x, y);
        this.colour = new Colour(value);
    }

    public Pixel(int x, int y, Colour colour) {
        this.point = new Point(x, y);
        this.colour = colour;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public char getColourValue() {
        return colour.getValue();
    }

    @Override
    public int compareTo(Pixel other) {
        int compareX = Integer.compare(point.getX(), other.getX());
        if (compareX != 0) {
            return compareX;
        } else {
            return Integer.compare(point.getY(), other.getY());
        }
    }
}
