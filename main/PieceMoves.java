package main;

import java.util.ArrayList;
import java.util.List;

public class PieceMoves {

    public static List<String> getPawnMoves(String position) {
        List<String> moves = new ArrayList<>();
        int row = position.charAt(1) - '0';
        char column = position.charAt(0);

        if (row < 8) { // pawn can only move forward if not on the last row
            moves.add("" + column + (row + 1));
        }
        return moves;
    }

    public static List<String> getKingMoves(String position) {
        List<String> moves = new ArrayList<>();
        int row = position.charAt(1) - '0';
        char column = position.charAt(0);

        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffsets[i];
            char newCol = (char) (column + colOffsets[i]);

            if (MoveUtils.isValidPosition(newCol, newRow)) {
                moves.add("" + newCol + newRow);
            }
        }
        return moves;
    }

    public static List<String> getQueenMoves(String position) {
        List<String> moves = new ArrayList<>();
        int row = position.charAt(1) - '0';
        char column = position.charAt(0);

        // directions for 'queen': Horizontal, Vertical, and Diagonal
        int[] rowOffsets = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] colOffsets = {0, 1, 0, -1, -1, 1, -1, 1};

        for (int i = 0; i < 8; i++) {
            int currentRow = row;
            char currentCol = column;

            while (true) {
                currentRow += rowOffsets[i];
                currentCol += colOffsets[i];

                if (MoveUtils.isValidPosition(currentCol, currentRow)) {
                    moves.add("" + currentCol + currentRow);
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
