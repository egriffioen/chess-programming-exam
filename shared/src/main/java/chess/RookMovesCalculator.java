package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RookMovesCalculator implements PieceMovesCalculator{
    Collection<ChessMove> moves = new ArrayList<>();
    public RookMovesCalculator() {
    }

    public Collection<ChessMove> calculatePieceMoves(ChessBoard board, ChessPosition myPosition) {
        addMoves(board, myPosition, 1,0);
        addMoves(board, myPosition, 0,1);
        addMoves(board, myPosition, -1,0);
        addMoves(board, myPosition, 0,-1);
        return moves;
    }
    public void addMoves(ChessBoard board, ChessPosition myPosition, int rowMove, int colMove) {
        for (int i=0;i<8;i++) {
            ChessPosition end = new ChessPosition(myPosition.getRow()+rowMove, myPosition.getColumn()+colMove);
            if(end.getRow()<1||end.getColumn()<1||end.getRow()>8||end.getColumn()>8){
                break;
            }
            else if(board.getPiece(end)==null) {
                ChessMove move = new ChessMove(myPosition, end, null);
                moves.add(move);
            }
            else if (board.getPiece(end).getTeamColor()!=board.getPiece(myPosition).getTeamColor()){
                ChessMove move = new ChessMove(myPosition, end, null);
                moves.add(move);
                break;
            }
            else if (board.getPiece(end).getTeamColor()==board.getPiece(myPosition).getTeamColor()){
                break;
            }

            if (rowMove>0){
                rowMove++;
            }
            else if(rowMove<0) {
                rowMove--;
            }
            if(colMove>0) {
                colMove++;
            }
            else if(colMove<0){
                colMove--;
            }
        }
    }
}
