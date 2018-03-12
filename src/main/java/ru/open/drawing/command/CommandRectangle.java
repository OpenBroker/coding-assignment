package ru.open.drawing.command;

import lombok.EqualsAndHashCode;
import ru.open.drawing.algo.BresenhamAlgo;
import ru.open.drawing.canvas.Canvas;
import ru.open.drawing.primitive.Colour;
import ru.open.drawing.primitive.Point;
import ru.open.drawing.primitive.Shape;
import lombok.Getter;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;

import java.util.Collections;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
@EqualsAndHashCode
public class CommandRectangle implements Command {

    private static final BresenhamAlgo lineAlgo = new BresenhamAlgo();
    public static final Colour RECTANGLE_COLOUR = new Colour('x');

    private final Point leftCorner;
    private final Point rightCorner;


    public CommandRectangle(Deque<String> args) {
        try {
            leftCorner = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            rightCorner = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for CommandRectangle should have 4 coordinates which represent as 4 integer values"
            );
        }
    }
    @Override
    public Shape draw(Canvas canvas) {
        return new Shape(IterableUtils.chainedIterable(
                lineAlgo.drawLine(leftCorner, new Point(rightCorner.getX(), leftCorner.getY()), RECTANGLE_COLOUR),
                lineAlgo.drawLine(leftCorner, new Point(leftCorner.getX(), rightCorner.getY()), RECTANGLE_COLOUR),
                lineAlgo.drawLine(new Point(leftCorner.getX(), rightCorner.getY()), rightCorner, RECTANGLE_COLOUR),
                lineAlgo.drawLine(new Point(rightCorner.getX(), leftCorner.getY()), rightCorner, RECTANGLE_COLOUR)
        ));

    }
}
