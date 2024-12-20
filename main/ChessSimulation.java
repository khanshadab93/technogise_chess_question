package main;

public class ChessSimulation {
    public static void main(String[] args) {
        // example inputs
        String input1 = "Pawn, G1";
        String input2 = "King, D5";
        String input3 = "Queen, E4";

        System.out.println("Input: " + input1 + " | Output: " + MoveUtils.getPossibleMoves(input1));
        System.out.println("Input: " + input2 + " | Output: " + MoveUtils.getPossibleMoves(input2));
        System.out.println("Input: " + input3 + " | Output: " + MoveUtils.getPossibleMoves(input3));
    }
}
