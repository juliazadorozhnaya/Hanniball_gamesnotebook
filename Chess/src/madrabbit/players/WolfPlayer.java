package madrabbit.players;

import game.core.*;
import madrabbit.moves.SimpleMove;
import game.core.Dirs;

import java.util.List;

/**
 * TODO Зайдуллин
 */
public class WolfPlayer extends WolfRabbitPlayer {


    @Override
    public String getName() {
        return "Волк";
    }

    @Override
    public String getAuthorName() {
        return "Зайдуллин";
    }

    @Override
    int getWeight(Move m) {
        int weight = 0;

        if (m instanceof SimpleMove) {
            Square source = ((SimpleMove) m).getSource();
            Square target = ((SimpleMove) m).getTarget();
            Board board = target.getBoard();
            Piece piece = m.getPiece();


            // Оценка позиции относительно углов доски.
            weight += evaluateCornerPosition(source, board) * (-10); // уменьшаем вес, если исходная позиция была в углу
            weight += evaluateCornerPosition(target, board) * 10; // увеличиваем вес, если целевая позиция будет в углу

            // Оценка риска быть захваченным кроликом.
            if (isRabbitNear(target, board)) {
                weight -= 20;
            }

        }
        return weight;
    }

    private boolean isRabbitNear(Square square, Board board) {
        int x = square.h;
        int y = square.v;

        // Смещения для проверки 8 соседних клеток: верх, низ, лево, право, и 4 диагонали.
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            // Проверяем, находится ли кролик на соседней клетке.
            if (isValid(newX, newY, board)) {
                Square adjacentSquare = board.getSquare(newX, newY);
                if (adjacentSquare != null && adjacentSquare.getPiece() != null) {
                    return true;
                }
            }
        }

        return false;
    }



    private boolean isValid(int x, int y, Board board) {
        // Проверяем, находится ли клетка в пределах доски.
        return x >= 0 && x < board.nH && y >= 0 && y < board.nV;
    }

    private int evaluateCornerPosition(Square square, Board board) {
        int h = square.h;
        int v = square.v;
        int nH = board.nH;
        int nV = board.nV;
        return ((h == 0 || h == nH - 1) && (v == 0 || v == nV - 1)) ? 1 : 0;
    }
}
