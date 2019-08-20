package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    //Слон может двигаться в четыре стороны. Эти движения можно описать двумя дельтами +1 -1.
    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }

        int size = 4;
        Cell[] steps = new Cell[size];
        int deltaX = 1;
        int deltaY = 1;

        for (int index = 0; index != size; index++) {
            dest.x = source.x + deltaX;
            dest.y = source.y + deltaY;
            steps[index] =  dest;
        }
//        return new Cell[] {dest};
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        //TODO check diagonal
        return false;
    }
}
