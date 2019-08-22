package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
public class BishopBlackTest {
    @Test
    public void whenCheckBishBlocksPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(Cell.C1, is(bishopBlack.position()));
    }

    @Test
    public void whenCheckBishBlocksWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishBlockWay = bishopBlack.way(Cell.C1, Cell.G5); //должен вернуть массив из 4 клеток. D2, E3, F4, G5
        Cell[] expect = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(expect, is(bishBlockWay));
      }

    @Test
    public void whenCheckCopyOfBishBlock() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure copy = bishopBlack.copy(Cell.C1);
        assertThat(copy.position(), is(Cell.C1));
    }

    @Test
    public void whenWayBishopBlackisDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(true, is(bishopBlack.isDiagonal(Cell.C1, Cell.G5)));
    }

    @Test
    public void whenFindByCoordinates() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(Cell.A1, is(bishopBlack.findByCoordinates(0,0)));
    }
}