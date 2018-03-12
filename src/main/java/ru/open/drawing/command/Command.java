package ru.open.drawing.command;

import ru.open.drawing.canvas.Canvas;
import ru.open.drawing.primitive.Shape;

/**
 * @author Ivan Zemlyanskiy
 */
public interface Command {

    Shape draw(Canvas canvas);

}
