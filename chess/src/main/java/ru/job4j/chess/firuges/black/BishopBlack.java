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
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }

        int size = dest.x - source.x;
        Cell[] steps = new Cell[size]; 
        Cell cell = source;
        int deltaX = 1;
        int deltaY = 1;

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
        if ((dest.x - source.x) == (dest.y - source.y)) {
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
