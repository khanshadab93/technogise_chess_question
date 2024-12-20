package main;

import java.util.ArrayList;
import java.util.List;

public class MoveUtils {

    public static String getPossibleMoves(String input) {
        String[] parts = input.split(", ");
        String pieceType = parts[0].trim();
        String position = parts[1].trim();

        List<String> possibleMoves = new ArrayList<>();

        switch (pieceType.toLowerCase()) {
            case "pawn":
                possibleMoves = PieceMoves.getPawnMoves(position);
                break;
            case "king":
                possibleMoves = PieceMoves.getKingMoves(position);
                break;
            case "queen":
                possibleMoves = PieceMoves.getQueenMoves(position);
                break;
            default:
                return "Invalid piece type!";
        }

        return String.join(", ", possibleMoves);
    }

    public static boolean isValidPosition(char column, int row) {
        return column >= 'A' && column <= 'H' && row >= 1 && row <= 8;
    }
}
