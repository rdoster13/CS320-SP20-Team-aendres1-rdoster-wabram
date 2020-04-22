package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Pawn;
import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.PieceType;

public class PawnTest {
	private Board board = new Board();

	private Pawn testPawn;
	/* Checks:
	 * Forward moves:
	 * 1 space
	 * 2 spaces
	 * capture diagonally, both sides
	 * 
	 * Backward Move: 
	 * should all be false, check simialr moves to the forward
	 */
	
	@Before
	public void setUp() {
		testPawn = new Pawn(PieceType.PAWN, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new Pawn(PieceType.PAWN, new Point(2, 6), 0));
		board.setPiece(new Pawn(PieceType.PAWN, new Point(3, 1), 1));
	}
	
	@Test
	public void TestGetPieceType() {
		assertEquals(testPawn.getPieceType(), PieceType.PAWN);
	}
	
	@Test
	public void TestGetColor() {
		assertEquals(testPawn.getColor(), 0);
	}
	
	@Test
	public void TestGetLocation() {
		assertEquals(testPawn.getPosition(), new Point(4, 0));
	}

	/* @Test
	public void testVerifyPromo() {
			
	}
	*/
	
	@Test
	public void TestWhiteCheckMove() {	
		//check move 2 spaces forwards from start
		assertTrue(board.getPiece(2, 6).checkMove(new Point(2, 4), board));
				
		//check move 1 space forward 
		assertTrue(board.getPiece(2, 6).checkMove(new Point(2, 5), board));
		
		//check move if another piece in the way
		board.setPiece(new Pawn(PieceType.PAWN, new Point(2, 5), 0));
		assertFalse(board.getPiece(2, 6).checkMove(new Point(2, 5), board));
		
		//check 2 space move if another piece in the way
		board.setPiece(new Pawn(PieceType.PAWN, new Point(2, 5), 0));
		assertFalse(board.getPiece(2, 6).checkMove(new Point(2, 4), board));
		
		//check move on the x-axis
		assertFalse(board.getPiece(2, 6).checkMove(new Point(1, 6), board));
		
		//check move backwards 
		assertFalse(board.getPiece(2, 6).checkMove(new Point(2, 7), board));
		
		//check move forward diagonally +x -y
		assertFalse(board.getPiece(2, 6).checkMove(new Point(3, 5), board));
		
		//check move forward diagonally -x -y
		assertFalse(board.getPiece(2, 6).checkMove(new Point(1, 5), board));
		
		//check move backward diagonally +x +y
		assertFalse(board.getPiece(2, 6).checkMove(new Point(3, 7), board));
		
		//check move backward diagonally -x +y
		assertFalse(board.getPiece(2, 6).checkMove(new Point(1, 7), board));
		
		//check capture +x -y
		board.setPiece(new Pawn(PieceType.PAWN, new Point(3, 5), 1));
		assertTrue(board.getPiece(2, 6).checkMove(new Point(3, 5), board));
		
		//check capture -x -y
		board.setPiece(new Pawn(PieceType.PAWN, new Point(1, 5), 1));
		assertTrue(board.getPiece(2, 6).checkMove(new Point(1, 5), board));
	}
	
	@Test
	public void TestBlackCheckMove() {
		//check move 2 spaces forwards from start
		assertTrue(board.getPiece(3, 1).checkMove(new Point(3, 3), board));		
		
		//check move 1 space forward 
		assertTrue(board.getPiece(3, 1).checkMove(new Point(3, 2), board));
		
		//check move if another piece in the way
		board.setPiece(new Pawn(PieceType.PAWN, new Point(3, 2), 1));
		assertFalse(board.getPiece(3, 1).checkMove(new Point(3, 2), board));
		
		//check 2 space move if another piece in the way
		board.setPiece(new Pawn(PieceType.PAWN, new Point(3, 2), 1));
		assertFalse(board.getPiece(3, 1).checkMove(new Point(3, 3), board));
		
		//check move on the x-axis
		assertFalse(board.getPiece(3, 1).checkMove(new Point(2, 1), board));
		
		//check move backwards 
		assertFalse(board.getPiece(3, 1).checkMove(new Point(3, 0), board));
		
		//check move forward diagonally +x -y
		assertFalse(board.getPiece(3, 1).checkMove(new Point(4, 2), board));
		
		//check move forward diagonally -x -y
		assertFalse(board.getPiece(3, 1).checkMove(new Point(2, 2), board));
		
		//check move backward diagonally +x +y
		assertFalse(board.getPiece(3, 1).checkMove(new Point(4, 0), board));
		
		//check move backward diagonally -x +y
		assertFalse(board.getPiece(3, 1).checkMove(new Point(2, 0), board));
		
		//check capture +x -y
		board.setPiece(new Pawn(PieceType.PAWN, new Point(4, 2), 0));
		assertTrue(board.getPiece(3, 1).checkMove(new Point(4, 2), board));
		
		//check capture -x -y
		board.setPiece(new Pawn(PieceType.PAWN, new Point(2, 2), 0));
		assertTrue(board.getPiece(3, 1).checkMove(new Point(2, 2), board));
						
	}

}
