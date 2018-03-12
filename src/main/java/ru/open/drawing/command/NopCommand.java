package ru.open.drawing.command;

import ru.open.drawing.canvas.Canvas;
import ru.open.drawing.primitive.Shape;

import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author Ivan Zemlyanskiy
 */
public class NopCommand implements Command {

    @Override
    public Shape draw(Canvas canvas) {
        // do nothing
        return new Shape(Collections::emptyIterator);

    }
}
