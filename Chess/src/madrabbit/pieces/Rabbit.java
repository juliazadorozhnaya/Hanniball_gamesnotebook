package madrabbit.pieces;

import game.core.*;
import madrabbit.moves.Capture;
import madrabbit.moves.SimpleMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rabbit extends Piece {

//    public boolean is_capture = false;

    public Rabbit(Square square, PieceColor color) {

        super(square, color);
    }

    @Override
    public boolean isCorrectMove(Square... squares) {
        // тут добавляем 2 типа ходов: простой и захват + надо добавить список захваченных фигур
        // надо добавить тип хода: захват фигуры и еще один захват
        Square source = this.square;


        Square target = squares[0];
        boolean res = false;
        // проверка если ход на шаг вперед
        if (target.isEmpty()) {
            if (target.isNear(source)) {
                res = (target.isDiagonal(source) || target.isVertical(source) || target.isHorizontal(source));
            }
            else {
                if (target.isHorizontal(source) && Math.abs(target.v - source.v) == 2) {
                    res = !target.isEmptyHorizontal(source);
                }
                else if (target.isVertical(source) && Math.abs(target.h - source.h) == 2) {
                    res = !target.isEmptyVertical(source);
                }
                else if (target.isDiagonal(source) && Math.abs(target.v - source.v) == 2 && Math.abs(target.h - source.h) == 2) {
                    res = !target.isEmptyDiagonal(source);
                }
            }
        }

        return res;
    }

    @Override
    public Move makeMove(Square... squares) {
        boolean is_capture;
        Square source = squares[0];
        Square target = squares[1];
        is_capture = (target.isHorizontal(source) && Math.abs(target.v - source.v) == 2)
                    || (target.isVertical(source) && Math.abs(target.h - source.h) == 2)
                    ||(target.isDiagonal(source) && Math.abs(target.v - source.v) == 2 && Math.abs(target.h - source.h) == 2);

        if (is_capture) {
//            Square source = squares[0];
//            Square target = squares[1];
//            Piece piece = source.getPiece();
//            piece.moveTo(target);
//            piece.moveTo(source);
            return new Capture(squares);
        }
        return new SimpleMove(squares);
    }

    @Override
    public String toString() {
        return "R";
    }
}
