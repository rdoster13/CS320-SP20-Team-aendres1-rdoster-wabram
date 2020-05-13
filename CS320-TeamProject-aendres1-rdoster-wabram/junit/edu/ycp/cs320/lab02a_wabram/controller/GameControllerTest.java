package edu.ycp.cs320.lab02a_wabram.controller;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.model.Game;
import edu.ycp.cs320.lab02a_wabram.model.King;
import edu.ycp.cs320.lab02a_wabram.model.Pawn;
import edu.ycp.cs320.lab02a_wabram.model.Piece;
import edu.ycp.cs320.lab02a_wabram.model.PieceType;
import edu.ycp.cs320.lab02a_wabram.model.Player;
import edu.ycp.cs320.lab02a_wabram.model.Position;
import edu.ycp.cs320.lab02a_wabram.model.Rook;

public class GameControllerTest {

	private GameController controller;
	private Game game;
	private Player player1, player2;

	@Before
	public void setUp() {
		game = new Game(player1, player2);
		controller = new GameController(game);
	}

	@Test
	public void testNewGame() {
		// this will also test getPieces
		// Creating a new board w/ new pieces.
		controller.newGame();

		// load the pieces from the DB
		controller.getPieces();

		// set them on the board
		game.getBoard();

		// Test to see if the Pawns are in their correct starting positions.
		for (int i = 0; i < 8; i++) {
			assertEquals(PieceType.PAWN, game.getBoard().getPosition(i, 1).getPiece().getPieceType());
			assertEquals(PieceType.PAWN, game.getBoard().getPosition(i, 6).getPiece().getPieceType());
		}

		// Test to see if Black Rooks, Knights, Bishops, the King, and the Queen are in
		// their correct
		// starting positions.
		assertEquals(PieceType.ROOK, game.getBoard().getPosition(0, 0).getPiece().getPieceType());
		assertEquals(PieceType.ROOK, game.getBoard().getPosition(0, 7).getPiece().getPieceType());

		assertEquals(PieceType.KNIGHT, game.getBoard().getPosition(1, 0).getPiece().getPieceType());
		assertEquals(PieceType.KNIGHT, game.getBoard().getPosition(6, 0).getPiece().getPieceType());

		assertEquals(PieceType.BISHOP, game.getBoard().getPosition(2, 0).getPiece().getPieceType());
		assertEquals(PieceType.BISHOP, game.getBoard().getPosition(5, 0).getPiece().getPieceType());

		assertEquals(PieceType.KING, game.getBoard().getPosition(4, 0).getPiece().getPieceType());
		assertEquals(PieceType.QUEEN, game.getBoard().getPosition(3, 0).getPiece().getPieceType());

	}

	@Test
	public void testGetTurn() {
		// create a new board first, to reset the turn values
		// Creating a new board w/ new pieces.
		controller.newGame();

		// load the pieces from the DB
		controller.getPieces();

		// set them on the board
		game.getBoard();

		controller.getTurn();
		assertEquals(0, controller.getTurn());

	}

	@Test
	public void testMovePiece() {
		// Creating a new board w/ new pieces.
		controller.newGame();

		// load the pieces from the DB
		controller.getPieces();

		// set them on the board
		game.getBoard();

		// Move the PAWN piece to space(0,3)
		Position start = game.getBoard().getPosition(0, 6);
		Position end = game.getBoard().getPosition(0, 4);
		controller.movePiece(start, end);

		// Test to see if space(0,4) contains a PAWN.
		assertEquals(PieceType.PAWN, game.getBoard().getPosition(0, 4).getPiece().getPieceType());

		// Test to see if space(0,6) is now empty.
		assertNull(game.getBoard().getPosition(0, 6).getPiece());

		// Move the KNIGHT piece to space(0,2)
		start = game.getBoard().getPosition(1, 0);
		end = game.getBoard().getPosition(0, 2);
		controller.movePiece(start, end);

		// Test to see if space(0, 2) contains a KNIGHT.
		assertEquals(PieceType.KNIGHT, game.getBoard().getPosition(0, 2).getPiece().getPieceType());

		// Test to see if space(1, 0) is now empty.
		assertNull(game.getBoard().getPosition(1, 0).getPiece());

	}

	@Test
	public void testTakePiece() {
		// Generate pawn adjacent to an opposing rook.
		Piece pawn = new Pawn(PieceType.PAWN, new Point(1, 0), 1);
		game.getBoard().setPiece(pawn);

		// create new POint to check if PAWN is off board
		Point offBoard = new Point(0, 8);
		
		Position pawnPos = new Position(pawn, pawn.getPosition());

		// Call takePiece
		// pawn should be moved off the board.
		controller.takePiece(pawnPos, game.getBoard().getPosition(0, 8));
		assertEquals(offBoard, pawn.getPosition());
	}

	@Test
	public void testEvaluateOppCheck() {
		// Create a scenario; king is adjacent to an opposing rook.
		Piece king = new King(PieceType.KING, new Point(1, 0), 1);
		Piece rook = new Rook(PieceType.ROOK, new Point(0, 0), 0);
		game.getBoard().setPiece(king);
		game.getBoard().setPiece(rook);

		Position start = new Position(rook, rook.getPosition());
		Position end = new Position(king, king.getPosition());

		// The rook is able to capture the king, the king should be in check.
		assertTrue(controller.evaluateOppCheck(0, start, end));

		// Remove the opposing rook.
		game.getBoard().getPosition(0, 0).setPiece(null);

	}

	/*
	 * @Test public void testCheckMate() { // Create a scenario; king is surrounded
	 * by rooks on all sides. game.getBoard().setPiece(new King(PieceType.KING, new
	 * Point(1,0), 1)); game.getBoard().setPiece(new Rook(PieceType.ROOK, new
	 * Point(0,0), 0)); game.getBoard().setPiece(new Rook(PieceType.ROOK, new
	 * Point(2,0), 0)); game.getBoard().setPiece(new Rook(PieceType.ROOK, new
	 * Point(0,1), 0)); game.getBoard().setPiece(new Rook(PieceType.ROOK, new
	 * Point(1,1), 0)); game.getBoard().setPiece(new Rook(PieceType.ROOK, new
	 * Point(2,1), 0));
	 * 
	 * // King should be in check. assertTrue(controller.checkmate());
	 * 
	 * // Get rid of the piece directly in front of the king.
	 * game.getBoard().getPosition(1, 1).setPiece(null);
	 * 
	 * // The king should NOT be in check. assertFalse(controller.checkmate()); }
	 * 
	 */

}
