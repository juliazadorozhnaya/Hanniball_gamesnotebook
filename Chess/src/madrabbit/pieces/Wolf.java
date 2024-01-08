package madrabbit.pieces;

import game.core.Move;
import game.core.Piece;
import game.core.PieceColor;
import game.core.Square;
import madrabbit.moves.SimpleMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Wolf extends Piece {
    public Wolf(Square square, PieceColor color) {
        super(square, color);
    }

    @Override
    public boolean isCorrectMove(Square... squares) {
        // тут добавляем какой ход является корректным (шаг на один)
        Square source = this.square;

        List<Square> moves = Arrays.stream(squares)
                .filter(Square::isEmpty)
                .filter(square -> square.isDiagonal(source) || square.isHorizontal(source) || square.isVertical(source))
                .filter(square -> square.isNear(source))
                .collect(Collectors.toList());
        return !moves.isEmpty();
    }

    @Override
    public Move makeMove(Square... squares) {
        return new SimpleMove(squares);
    }

    @Override
    public String toString() {
        return "W";
    }
}
