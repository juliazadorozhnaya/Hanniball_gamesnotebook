package madrabbit.moves;

import game.core.*;
import game.core.moves.ITransferMove;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Capture implements ITransferMove {
    /**
     * Какая фигура перемещается.
     */
    protected final Piece piece;

    /**
     * Захваченная фигура.
     */
    private Piece capturedPiece;

    /**
     * Расположение захваченной фигуры.
     */
    private Square capturedSquare;

    /**
     * Откуда перемещается.
     */
    protected final Square source;

    /**
     * Куда перемещается.
     */
    protected final Square target;

    public void getCaptured() {
        Board board = target.getBoard();

        int ver, hor;

        if (target.v < source.v) { ver = source.v - 1; }
        else if (target.v > source.v) { ver = source.v + 1; }
        else { ver = source.v; }

        if (target.h < source.h) { hor = source.h - 1; }
        else if (target.h > source.h) { hor = source.h + 1; }
        else { hor = source.h; }

        this.capturedSquare = board.getSquare(ver, hor);
        this.capturedPiece = this.capturedSquare.getPiece();

    }

    public Capture(Square[] squares) {
        source = squares[0];
        target = squares[1];

        // вот тут ставим проверку есть ли между этим двумя клетками Волк
        // не тут

        getCaptured();

        piece = source.getPiece();
    }

    @Override
    public void doMove() throws GameOver {
        // вот тут уже знаем что ход верный и между source и target съеденная фигура
        capturedPiece.remove();
        piece.moveTo(target);
        if (piece.getEnemies().size() <= 9) {
            throw new GameOver(GameResult.BLACK_WIN);
        }
    }

    @Override
    public void undoMove() {
        capturedSquare.setPiece(capturedPiece);
        piece.moveTo(source);
    }

    @Override
    public String toString() {
        return "" + piece + source + "-" + target;
    }

    @Override
    public Square getSource() {
        return source;
    }

    @Override
    public Square getTarget() {
        return target;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }
}
