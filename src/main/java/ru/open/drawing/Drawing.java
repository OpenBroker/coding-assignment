package ru.open.drawing;

import ru.open.drawing.canvas.CanvasManager;
import ru.open.drawing.canvas.ConsoleCanvas;
import ru.open.drawing.command.*;

import java.io.*;
import java.util.Scanner;

/**
 * @author Ivan Zemlyanskiy
 */
public class Drawing {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);


        Writer writer = new PrintWriter(System.out, true);
        CanvasManager manager = new CanvasManager(new ConsoleCanvas());

        CommandParser parser = new CommandParser();
        Command command;
        do {
            writer.write("Input command: ");
            writer.flush();
            String input = scanner.nextLine();

            try {
                command = parser.parseCommand(input);
            } catch (IllegalCommandException | IllegalArgumentException e) {
                writer.write("Verify your input! Error message: " + e.getMessage() + "\n");
                command = new NopCommand();
            }

            try {
                manager.applyCommand(command);

                manager.show(writer);
                writer.write('\n');
            } catch (IllegalStateException e) {
                writer.write(e.getMessage());
            }

        } while (!command.getClass().equals(Quit.class));

        scanner.close();

    }


}
