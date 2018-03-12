package ru.open.drawing.algo;

import ru.open.drawing.canvas.Canvas;
import ru.open.drawing.canvas.ConsoleCanvas;
import ru.open.drawing.primitive.Colour;
import ru.open.drawing.primitive.Pixel;
import ru.open.drawing.primitive.Point;
import ru.open.drawing.primitive.Shape;
import org.apache.commons.collections4.IterableUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author Ivan Zemlyanskiy
 */
public class FloodFill4Test {

    @Test
    public void fill() {
        FloodFill4 algo = new FloodFill4();
        Canvas canvas = new ConsoleCanvas();
        canvas.init(3, 3);

        Shape fill = algo.fill(canvas, new Point(1, 1), new Colour('o'));
        assertEquals(Arrays.asList(new Pixel(0, 0, 'o'),
                                   new Pixel(0, 1, 'o'),
                                   new Pixel(0, 2, 'o'),

                                   new Pixel(1, 0, 'o'),
                                   new Pixel(1, 1, 'o'),
                                   new Pixel(1, 2, 'o'),

                                   new Pixel(2, 0, 'o'),
                                   new Pixel(2, 1, 'o'),
                                   new Pixel(2, 2, 'o')
                     ),
                     IterableUtils.toList(fill).stream().sorted().collect(Collectors.toList()));
    }
}