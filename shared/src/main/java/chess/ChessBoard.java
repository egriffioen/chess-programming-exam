package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    private ChessPiece[][] squares = new ChessPiece[8][8];
    public ChessBoard() {
        
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow()-1][position.getColumn()-1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()-1][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        resetPawns();
        resetRooks();
        resetKnights();
        resetBishops();
        resetQueens();
        resetKings();
    }

    public void resetPawns() {
        for (int i=0;i<8;i++) {
            ChessPiece wpawn = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            ChessPosition wpos = new ChessPosition(2,i+1);
            addPiece(wpos, wpawn);
        }
        for (int i=0;i<8;i++) {
            ChessPiece bpawn = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
            ChessPosition bpos = new ChessPosition(7,i+1);
            addPiece(bpos, bpawn);
        }
    }

    public void resetRooks() {
            ChessPiece wlpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
            ChessPosition wlpos = new ChessPosition(1,1);
            addPiece(wlpos, wlpiece);

        ChessPiece wrpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        ChessPosition wrpos = new ChessPosition(1,8);
        addPiece(wrpos, wrpiece);

            ChessPiece blpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
            ChessPosition blpos = new ChessPosition(8,1);
            addPiece(blpos, blpiece);

        ChessPiece brpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
        ChessPosition brpos = new ChessPosition(8,8);
        addPiece(brpos, brpiece);
    }

    public void resetKnights() {
        ChessPiece wlpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        ChessPosition wlpos = new ChessPosition(1,2);
        addPiece(wlpos, wlpiece);

        ChessPiece wrpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        ChessPosition wrpos = new ChessPosition(1,7);
        addPiece(wrpos, wrpiece);

        ChessPiece blpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        ChessPosition blpos = new ChessPosition(8,2);
        addPiece(blpos, blpiece);

        ChessPiece brpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        ChessPosition brpos = new ChessPosition(8,7);
        addPiece(brpos, brpiece);
    }

    public void resetBishops() {
        ChessPiece wlpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        ChessPosition wlpos = new ChessPosition(1,3);
        addPiece(wlpos, wlpiece);

        ChessPiece wrpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        ChessPosition wrpos = new ChessPosition(1,6);
        addPiece(wrpos, wrpiece);

        ChessPiece blpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        ChessPosition blpos = new ChessPosition(8,3);
        addPiece(blpos, blpiece);

        ChessPiece brpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        ChessPosition brpos = new ChessPosition(8,6);
        addPiece(brpos, brpiece);
    }

    public void resetQueens() {
        ChessPiece wlpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        ChessPosition wlpos = new ChessPosition(1,4);
        addPiece(wlpos, wlpiece);

        ChessPiece blpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        ChessPosition blpos = new ChessPosition(8,4);
        addPiece(blpos, blpiece);
    }

    public void resetKings() {
        ChessPiece wlpiece = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        ChessPosition wlpos = new ChessPosition(1,5);
        addPiece(wlpos, wlpiece);

        ChessPiece blpiece = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        ChessPosition blpos = new ChessPosition(8,5);
        addPiece(blpos, blpiece);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(squares, that.squares);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(squares);
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "squares=" + Arrays.toString(squares) +
                '}';
    }
}
