package ru.open.drawing.command;

import lombok.EqualsAndHashCode;
import ru.open.drawing.algo.FloodFill4;
import ru.open.drawing.canvas.Canvas;
import ru.open.drawing.primitive.Colour;
import ru.open.drawing.primitive.Point;
import ru.open.drawing.primitive.Shape;
import lombok.Getter;

import java.util.Collections;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
@EqualsAndHashCode
public class CommandBucketFill implements Command {
    private static FloodFill4 fillAlgo = new FloodFill4();

    private final Point startPoint;
    private final Colour colour;

    public CommandBucketFill(Deque<String> args) {
        try {
            startPoint = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            String colour = args.pop();
            if (colour.length() != 1) {
                throw new IllegalArgumentException("Colour should be represent as single character");
            }
            this.colour = new Colour(colour.toCharArray()[0]);

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for CommandBucketFill should have 2 coordinates which represent as 2 integer values and a colour which represents as any symbol"
            );
        }
    }

    @Override
    public Shape draw(Canvas canvas) {
        return fillAlgo.fill(canvas, startPoint, colour);

    }
}
