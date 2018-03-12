package ru.open.drawing.command;

import lombok.EqualsAndHashCode;
import ru.open.drawing.algo.BresenhamAlgo;
import ru.open.drawing.canvas.Canvas;
import ru.open.drawing.primitive.Colour;
import ru.open.drawing.primitive.Point;
import ru.open.drawing.primitive.Shape;
import lombok.Getter;

import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * @author Ivan Zemlyanskiy
 */
@Getter
@EqualsAndHashCode
public class CommandLine implements Command {

    public static final Colour LINE_COLOUR = new Colour('x');
    private static final BresenhamAlgo lineAlgo = new BresenhamAlgo();

    private final Point start;
    private final Point end;

    public CommandLine(Deque<String> args) {
        try {
            start = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));
            end = new Point(Integer.valueOf(args.pop()), Integer.valueOf(args.pop()));

        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Arguments for CommandLine should have 4 coordinates which represent as 4 integer values"
            );
        }
    }

    @Override
    public Shape draw(Canvas canvas) {
        return lineAlgo.drawLine(start, end, LINE_COLOUR);
    }

}
