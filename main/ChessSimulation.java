package main;

import java.util.ArrayList;
import java.util.List;

public class ChessSimulation {
    public static void main(String[] args) {
        // example inputs
        String input1 = "Pawn, G1";
        String input2 = "King, D5";
        String input3 = "Queen, E4";

        System.out.println("Input: " + input1 + " | Output: " + getPossibleMoves(input1));
        System.out.println("Input: " + input2 + " | Output: " + getPossibleMoves(input2));
        System.out.println("Input: " + input3 + " | Output: " + getPossibleMoves(input3));
    }

    // funstion to get possible moves for a given input
    public static String getPossibleMoves(String input) {
        String[] parts = input.split(", ");
        String pieceType = parts[0].trim();
        String position = parts[1].trim();

        List<String> possibleMoves = new ArrayList<>();

        switch (pieceType.toLowerCase()) {
            case "pawn":
                possibleMoves = getPawnMoves(position);
                break;
            case "king":
                possibleMoves = getKingMoves(position);
                break;
            case "queen":
                possibleMoves = getQueenMoves(position);
                break;
            default:
                return "Invalid piece type!";
        }

        return String.join(", ", possibleMoves);
    }

    // function to calculate 'pawn' moves
    public static List<String> getPawnMoves(String position) {
        List<String> moves = new ArrayList<>();
        int row = position.charAt(1) - '0';
        char column = position.charAt(0);

        if (row < 8) { // pawn can only move forward if not on the last row
            moves.add("" + column + (row + 1));
        }
        return moves;
    }

    // function to calculate 'king' moves
    public static List<String> getKingMoves(String position) {
        List<String> moves = new ArrayList<>();
        int row = position.charAt(1) - '0';
        char column = position.charAt(0);

        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffsets[i];
            char newCol = (char) (column + colOffsets[i]);

            if (isValidPosition(newCol, newRow)) {
                moves.add("" + newCol + newRow);
            }
        }
        return moves;
    }

    // function to calculate 'queen' moves
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

                if (isValidPosition(currentCol, currentRow)) {
                    moves.add("" + currentCol + currentRow);
                } else {
                    break;
                }
            }
        }
        return moves;
    }

    // function to check if a position is valid
    public static boolean isValidPosition(char column, int row) {
        return column >= 'A' && column <= 'H' && row >= 1 && row <= 8;
    }
}
