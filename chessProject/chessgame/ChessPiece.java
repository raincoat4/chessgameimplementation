package chessgame;
import java.util.HashSet;
public class ChessPiece {
    int x;
    int y;
    int x2;
    int y2;
    boolean isWhite;
    HashSet<ChessPiece> pieces;
    String name;
    public ChessPiece(int x, int y, boolean isWhite, String name, HashSet<ChessPiece> pieces){
        this.x = x;
        this.y = y;
        x2 = x*64;
        y2 = y*64;
        this.isWhite = isWhite;
        this.pieces = pieces;
        this.name = name;
        pieces.add(this);
    }    
        public void move(int x, int y) {
        int newX = x * 64;
        int newY = y * 64;
        
        ChessPiece pieceAtNewPosition = ChessGame.getPiece(newX, newY);
        
        if (pieceAtNewPosition != null && pieceAtNewPosition.isWhite == true) {
            if (pieceAtNewPosition.isWhite != isWhite) {
                pieces.remove(pieceAtNewPosition);
            } else {
                x2 = this.x * 64;
                y2 = this.y * 64;
                return;
            }
        }
        
        this.x = x;
        this.y = y;
        x2 = newX;
        y2 = newY;
    }

}
