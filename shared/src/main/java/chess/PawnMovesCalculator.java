package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMovesCalculator implements PieceMovesCalculator{
    Collection<ChessMove> moves = new ArrayList<>();
    public PawnMovesCalculator() {
    }

    public Collection<ChessMove> calculatePieceMoves(ChessBoard board, ChessPosition myPosition) {
        if(board.getPiece(myPosition).getTeamColor()== ChessGame.TeamColor.WHITE){
            addMoves(board, myPosition, 1,0);
            return moves;
        }
        else {
            addMoves(board, myPosition, -1,0);
            return moves;
        }

    }
    public void addMoves(ChessBoard board, ChessPosition myPosition, int rowMove, int colMove) {
        ChessPosition end = new ChessPosition(myPosition.getRow()+rowMove, myPosition.getColumn()+colMove);
        if(end.getRow()<1||end.getColumn()<1||end.getRow()>8||end.getColumn()>8){
            return;
        }
        else if(board.getPiece(end)==null) {
            if (checkPromotionMoves(myPosition, end, board)) {
                addPromotionMoves(myPosition,end);
            }
            else {
                ChessMove move = new ChessMove(myPosition, end, null);
                moves.add(move);
                if (board.getPiece(myPosition).getTeamColor()== ChessGame.TeamColor.WHITE&&myPosition.getRow()==2) {
                    ChessPosition fwpos = new ChessPosition(myPosition.getRow()+2, myPosition.getColumn());
                    if (board.getPiece(fwpos)==null) {
                        ChessMove fwmove = new ChessMove(myPosition, fwpos, null);
                        moves.add(fwmove);
                    }
                }
                else if (board.getPiece(myPosition).getTeamColor()== ChessGame.TeamColor.BLACK&&myPosition.getRow()==7) {
                    ChessPosition fbpos = new ChessPosition(myPosition.getRow()-2, myPosition.getColumn());
                    if (board.getPiece(fbpos)==null) {
                        ChessMove fbmove = new ChessMove(myPosition, fbpos, null);
                        moves.add(fbmove);
                    }
                }
            }

        }
        ChessPosition captureLeft = new ChessPosition(myPosition.getRow()+rowMove, myPosition.getColumn()-1);
        ChessPosition captureRight = new ChessPosition(myPosition.getRow()+rowMove, myPosition.getColumn()+1);
        addCapture(board,myPosition, captureLeft);
        addCapture(board, myPosition, captureRight);

    }

    public boolean checkPromotionMoves(ChessPosition myPosition, ChessPosition end, ChessBoard board) {
        if(board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
            if(end.getRow()==8){
                return true;
            }
        }
        else if(board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.BLACK) {
            if(end.getRow()==1){
                return true;
            }
        }
        else{
            return false;
        }
        return false;
    }

    public void addPromotionMoves(ChessPosition startPosition, ChessPosition end){
        ChessMove bishopMove = new ChessMove(startPosition, end, ChessPiece.PieceType.BISHOP);
        ChessMove rookMove = new ChessMove(startPosition, end, ChessPiece.PieceType.ROOK);
        ChessMove queenMove = new ChessMove(startPosition, end, ChessPiece.PieceType.QUEEN);
        ChessMove knightMove = new ChessMove(startPosition, end, ChessPiece.PieceType.KNIGHT);
        moves.add(bishopMove);
        moves.add(rookMove);
        moves.add(queenMove);
        moves.add(knightMove);
    }

    public void addCapture(ChessBoard board, ChessPosition myPosition, ChessPosition capture){
        if(capture.getRow()<1||capture.getColumn()<1||capture.getRow()>8||capture.getColumn()>8){
            return;
        }
        else if (board.getPiece(capture)==null) {
            return;
        }
        else if (board.getPiece(myPosition).getTeamColor()!=board.getPiece(capture).getTeamColor()){
            if(checkPromotionMoves(myPosition, capture, board)){
                addPromotionMoves(myPosition,capture);
            }
            else{
                ChessMove captureMove = new ChessMove(myPosition, capture, null);
                moves.add(captureMove);
            }
        }
    }
}

