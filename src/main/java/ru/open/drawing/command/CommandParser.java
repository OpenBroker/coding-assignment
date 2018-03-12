package ru.open.drawing.command;


import lombok.NonNull;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author Ivan Zemlyanskiy
 */
public class CommandParser {


    public Command parseCommand(@NonNull String input) throws IllegalCommandException, IllegalArgumentException {
        String[] split = input.trim().split("\\s");
        Deque<String> tokens = new ArrayDeque<>(Arrays.asList(split));

        String command = tokens.pop();
        return Stream.of(CommandType.values())
                .map(commandType -> commandType.parse(command))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(CommandType::getCommandSupplier)
                .map(function -> function.apply(tokens))
                .findAny().orElseThrow(() -> new IllegalCommandException("Unknown command"));



    }
}
