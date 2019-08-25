package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import sun.rmi.runtime.Log;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    @Test
    public void whenFigureMove() {
        Logic logic = new Logic();
        assertThat(false, is(logic.move(Cell.C1, Cell.G5)));
    }

    @Test
    public void whenCleanNewFigure() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.clean();
        assertNull(null);
    }
}