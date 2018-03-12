package ru.open.drawing.canvas;

import ru.open.drawing.primitive.Pixel;
import ru.open.drawing.primitive.Point;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/**
 * @author Ivan Zemlyanskiy
 */
public interface Canvas {

    void init(int width, int height);

    boolean drawPixel(Pixel pixel);

    Optional<Pixel> getPixel(Point point);

    void show(Writer writer) throws IOException;
}
