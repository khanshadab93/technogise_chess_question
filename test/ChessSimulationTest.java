package test;

import main.ChessSimulation;
import org.junit.Test;

import java.util.List;

import static org.junit.gen5.api.Assertions.*;

public class ChessSimulationTest {

    @Test
    public void testPawnMoves() {
        List<String> moves = ChessSimulation.getPawnMoves("G1");
        assertEquals(List.of("G2"), moves, "Pawn at G1 should move to G2");

        moves = ChessSimulation.getPawnMoves("D7");
        assertEquals(List.of("D8"), moves, "Pawn at D7 should move to D8");

        moves = ChessSimulation.getPawnMoves("A8");
        assertTrue(moves.isEmpty(), "Pawn at A8 should have no valid moves");
    }

    @Test
    public void testKingMoves() {
        List<String> moves = ChessSimulation.getKingMoves("D5");
        assertEquals(List.of("C4", "D4", "E4", "C5", "E5", "C6", "D6", "E6"), moves,
                "King at D5 should have 8 possible moves");

        moves = ChessSimulation.getKingMoves("A1");
        assertEquals(List.of("B1", "A2", "B2"), moves, "King at A1 should have 3 possible moves");

        moves = ChessSimulation.getKingMoves("H8");
        assertEquals(List.of("G7", "H7", "G8"), moves, "King at H8 should have 3 possible moves");
    }

    @Test
    public void testQueenMoves() {
        List<String> moves = ChessSimulation.getQueenMoves("E4");
        assertTrue(moves.contains("A4") && moves.contains("E1") && moves.contains("H4"),
                "Queen at E4 should have all horizontal, vertical, and diagonal moves covered");

        moves = ChessSimulation.getQueenMoves("A1");
        assertTrue(moves.contains("H8"), "Queen at A1 should have diagonal moves up to H8");

        moves = ChessSimulation.getQueenMoves("H8");
        assertTrue(moves.contains("A1"), "Queen at H8 should have diagonal moves down to A1");
    }

    @Test
    public void testGetPossibleMoves() {
        String result = ChessSimulation.getPossibleMoves("Pawn, G1");
        assertEquals("G2", result, "Pawn at G1 should move to G2");

        result = ChessSimulation.getPossibleMoves("King, D5");
        assertEquals("C4, D4, E4, C5, E5, C6, D6, E6", result, "King at D5 should have 8 moves");

        result = ChessSimulation.getPossibleMoves("Queen, E4");
        assertTrue(result.contains("A4") && result.contains("H4") && result.contains("E8"),
                "Queen at E4 should cover all directions");

        result = ChessSimulation.getPossibleMoves("Rook, A1");
        assertEquals("Invalid piece type!", result, "Invalid piece type should return an error message");
    }

    @Test
    public void testInvalidInput() {
        String result = ChessSimulation.getPossibleMoves("Knight, B1");
        assertEquals("Invalid piece type!", result, "Knight should return an invalid type error");
    }

    @Test
    public void testIsValidPosition() {
        assertTrue(ChessSimulation.isValidPosition('A', 1), "A1 should be a valid position");
        assertTrue(ChessSimulation.isValidPosition('H', 8), "H8 should be a valid position");

        assertFalse(ChessSimulation.isValidPosition('I', 5), "I5 is invalid because column exceeds H");
        assertFalse(ChessSimulation.isValidPosition('B', 0), "B0 is invalid because row is less than 1");
        assertFalse(ChessSimulation.isValidPosition('C', 9), "C9 is invalid because row exceeds 8");
    }
}