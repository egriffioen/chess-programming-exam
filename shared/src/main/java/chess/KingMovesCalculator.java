package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class KingMovesCalculator implements PieceMovesCalculator{
    Collection<ChessMove> moves = new ArrayList<>();
    public KingMovesCalculator() {
    }

    public Collection<ChessMove> calculatePieceMoves(ChessBoard board, ChessPosition myPosition) {
        addMoves(board, myPosition, 1,1);
        addMoves(board, myPosition, 1,-1);
        addMoves(board, myPosition, -1,1);
        addMoves(board, myPosition, -1,-1);
        addMoves(board, myPosition, 1,0);
        addMoves(board, myPosition, 0,1);
        addMoves(board, myPosition, -1,0);
        addMoves(board, myPosition, 0,-1);
        return moves;
    }
    public void addMoves(ChessBoard board, ChessPosition myPosition, int rowMove, int colMove) {

            ChessPosition end = new ChessPosition(myPosition.getRow()+rowMove, myPosition.getColumn()+colMove);
            if(end.getRow()<1||end.getColumn()<1||end.getRow()>8||end.getColumn()>8){
                return;
            }
            else if(board.getPiece(end)==null) {
                ChessMove move = new ChessMove(myPosition, end, null);
                moves.add(move);
            }
            else if (board.getPiece(end).getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                ChessMove move = new ChessMove(myPosition, end, null);
                moves.add(move);
                return;
            }
            else if (board.getPiece(end).getTeamColor()==board.getPiece(myPosition).getTeamColor()){
                return;
            }

    }
}
