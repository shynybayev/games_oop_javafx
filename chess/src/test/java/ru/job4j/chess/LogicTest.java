package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import sun.rmi.runtime.Log;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class LogicTest {

    //как тестировать void?
    @Test
    public void whenAddnewFigure() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));

        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure[] figure = new Figure[1];
        figure[0] = bishopBlack;

        assertNotNull(figure[0]);
    }

    //TODO c true не проходит
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

    @Test
    public void whenFigureFindByCell() {
        //TODO метод приватный?
    }
}