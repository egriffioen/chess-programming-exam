package chess;

import java.util.ArrayList;
import java.util.Collection;

public interface PieceMovesCalculator {
    public Collection<ChessMove> calculatePieceMoves(ChessBoard board, ChessPosition myPosition);
}
