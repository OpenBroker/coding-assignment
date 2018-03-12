package ru.open.drawing.command;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Ivan Zemlyanskiy
 */
public class CommandParserTest {

    private CommandParser parser = new CommandParser();

    @Test
    public void parseCreateCanvas() {
        String input = "C 1 2";
        Command command = parser.parseCommand(input);
        assertEquals(CommandNewCanvas.class, command.getClass());
        CommandNewCanvas newCanvas = (CommandNewCanvas) command;
        assertEquals(1, newCanvas.getWidth());
        assertEquals(2, newCanvas.getHeight());
    }

    @Test
    public void parseCreateLine() {
        String input = "L 1 2 3 4";
        Command command = parser.parseCommand(input);
        assertEquals(CommandLine.class, command.getClass());
        CommandLine line = (CommandLine) command;
        assertEquals(1, line.getStart().getX());
        assertEquals(2, line.getStart().getY());
        assertEquals(3, line.getEnd().getX());
        assertEquals(4, line.getEnd().getY());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseBadCommandCreateLine() {
        String input = "L 1 2 3";
        Command command = parser.parseCommand(input);
    }

    @Test
    public void parseCreateRectangle() {
        String input = "R 1 2 3 4";
        Command command = parser.parseCommand(input);
        assertEquals(CommandRectangle.class, command.getClass());
        CommandRectangle rectangle = (CommandRectangle) command;
        assertEquals(1, rectangle.getLeftCorner().getX());
        assertEquals(2, rectangle.getLeftCorner().getY());
        assertEquals(3, rectangle.getRightCorner().getX());
        assertEquals(4, rectangle.getRightCorner().getY());
    }

    @Test
    public void parseCreateBucketFill() {
        String input = "B 1 2 o";
        Command command = parser.parseCommand(input);
        assertEquals(CommandBucketFill.class, command.getClass());
        CommandBucketFill bucketFill = (CommandBucketFill) command;
        assertEquals(1, bucketFill.getStartPoint().getX());
        assertEquals(2, bucketFill.getStartPoint().getY());
        assertEquals("o".charAt(0), bucketFill.getColour().getValue());
    }

    @Test
    public void parseCreateQuit() {
        String input = "Q";
        assertEquals(Quit.class, parser.parseCommand(input).getClass());
    }

    @Test(expected = IllegalCommandException.class)
    public void parseWrongInput() {
        String input = "No Command Here";
        parser.parseCommand(input);
    }


    @Test(expected = IllegalCommandException.class)
    public void parseEmptyInput() {
        String input = "";
        parser.parseCommand(input);
    }


}