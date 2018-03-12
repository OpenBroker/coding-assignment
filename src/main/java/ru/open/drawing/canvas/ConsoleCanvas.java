package ru.open.drawing.canvas;

import ru.open.drawing.primitive.Colour;
import ru.open.drawing.primitive.Pixel;
import ru.open.drawing.primitive.Point;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/**
 * @author Ivan Zemlyanskiy
 */
public class ConsoleCanvas implements Canvas {

    private boolean init = false;

    private int width = 0;
    private int height = 0;

    private char[][] matrix;

    @Override
    public void init(int width, int height) {
        this.width = width;
        this.height = height;

        matrix = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = ' ';
            }
        }

        init = true;
    }

    @Override
    public boolean drawPixel(Pixel pixel) {
        checkState();
        if (pointOutOfBound(pixel.getPoint())) {
            return false;
        }

        matrix[pixel.getY()][pixel.getX()] = pixel.getColourValue();
        return true;
    }

    @Override
    public Optional<Pixel> getPixel(Point point) {
        if (pointOutOfBound(point)) {
            return Optional.empty();
        }
        return Optional.of(new Pixel(point, new Colour(matrix[point.getY()][point.getX()])));
    }

    @Override
    public void show(Writer writer) throws IOException {
        if (!init) {
            return;
        }

        for (int i = 0; i < width + 2; i++) {
            writer.append('-');
        }
        writer.append("\n");

        for (int i = 0; i < height; i++) {
            writer.append('|');
            for (char c : matrix[i]) {
                writer.append(c);
            }
            writer.append("|\n");
        }

        for (int i = 0; i < width + 2; i++) {
            writer.append('-');
        }
        writer.append("\n");
        writer.flush();
    }

    private void checkState() {
        if (!init) {
            throw new IllegalStateException("Canvas wasn't initialized!");
        }
    }

    private boolean pointOutOfBound(Point point) {
        return point.getX() < 0 || point.getY() < 0 || point.getX() >= width || point.getY() >= height;
    }
}
