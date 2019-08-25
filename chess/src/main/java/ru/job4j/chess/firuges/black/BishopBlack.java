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

    @Override
    public Cell[] way(Cell source, Cell dest) { //G5(6,4) и F6(5,5)
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }

        int size;
        if (source.y > dest.y) {
            size = source.y - dest.y;
        } else {
            size = dest.y - source.y;
        }

        Cell[] steps = new Cell[size];
        Cell cell = source;
        int deltaX = dest.x > source.x ? 1: -1;
        int deltaY = dest.y > source.y ? 1: -1;

        for (int index = 0; index != size; index++) {   
            cell = findByCoordinates(cell.x + deltaX, cell.y + deltaY);
            steps[index] = cell;
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y)) {
            return true;
        }
        return false;
    }

    //метод поиска Cell по координатам
    public Cell findByCoordinates(int x, int y) {
       Cell[] cells = Cell.values();
       Cell cell = position;
       for (Cell tmp: cells) {
           if (tmp.x == x & tmp.y == y) {
               cell = tmp;
           }
       }
       return cell;
    }
}
