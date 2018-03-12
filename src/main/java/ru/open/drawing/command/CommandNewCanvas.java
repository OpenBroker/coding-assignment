package ru.open.drawing.command;

import lombok.EqualsAndHashCode;
import ru.open.drawing.canvas.Canvas;
import ru.open.drawing.primitive.Shape;
import lombok.Getter;

import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
@EqualsAndHashCode
public class CommandNewCanvas implements Command {

    private final int width;
    private final int height;

    public CommandNewCanvas(Deque<String> args) {
        try {
            width = Integer.valueOf(args.pop());
            height = Integer.valueOf(args.pop());

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for CommandNewCanvas should have width and height which represent as 2 integer values"
            );
        }
    }

    @Override
    public Shape draw(Canvas canvas) {
        canvas.init(width, height);
        return new Shape(Collections::emptyIterator);
    }
}
