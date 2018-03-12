package ru.open.drawing.algo;

import ru.open.drawing.primitive.Colour;
import ru.open.drawing.primitive.Pixel;
import ru.open.drawing.primitive.Point;
import ru.open.drawing.primitive.Shape;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @author Ivan Zemlyanskiy
 */
public class BresenhamAlgoTest {

    private BresenhamAlgo algo = new BresenhamAlgo();

    @Test
    public void drawLine() {
        Shape line = algo.drawLine(new Point(0, 1), new Point(6, 4), new Colour('x'));

        assertEquals(Arrays.asList(new Pixel(0, 1, 'x'),
                                   new Pixel(1, 2, 'x'),
                                   new Pixel(2, 2, 'x'),
                                   new Pixel(3, 3, 'x'),
                                   new Pixel(4, 3, 'x'),
                                   new Pixel(5, 4, 'x'),
                                   new Pixel(6, 4, 'x')
                     ),
                     IterableUtils.toList(line));

    }
    

    @Test
    public void drawDot() {
        Shape line = algo.drawLine(new Point(0, 0), new Point(0, 0), new Colour('x'));

        assertEquals(Collections.singletonList(new Pixel(0, 0, 'x')),
                     IterableUtils.toList(line));
    }

    



}