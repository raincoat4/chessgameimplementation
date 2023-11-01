package chessgame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.Random;
public class ChessGame {
    //dont know how to fix this warning
    public static HashSet<ChessPiece> pieces = new HashSet(); //stores all piece in hashset, i thought it would be good but i couldve used a list and it wouldve been the same
    public static ChessPiece selectedChessPiece = null; //used when moving pieces
    public static void main(String[] args) throws IOException {

        BufferedImage all = ImageIO.read(new File("D:\\download\\code\\chessjava\\chessgame\\chess.png"));
        Image images[] = new Image[12];
        int i = 0;
        //tweaked these numbers so that it would read each piece from the image properly
        for(int y = 0; y<400; y+=200){
            for(int x = 0; x<1200; x+=200){
                images[i] = all.getSubimage(x,y,200,200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                i+=1;
            }
        }
        //making pieces left to right starting with black - i want to find a way to automate/make this better, but im lazy rn
        ChessPiece bRook = new ChessPiece(0,0,false,"rook",pieces);
        ChessPiece bKnight = new ChessPiece(1,0,false,"knight",pieces);
        ChessPiece bBishop = new ChessPiece(2,0,false,"bishop",pieces);
        ChessPiece bQueen = new ChessPiece(3,0,false,"queen",pieces);
        ChessPiece bKing = new ChessPiece(4,0,false,"king",pieces);
        ChessPiece bBishop2 = new ChessPiece(5,0,false,"bishop",pieces);
        ChessPiece bKnight2 = new ChessPiece(6,0,false,"knight",pieces);
        ChessPiece bRook2 = new ChessPiece(7,0,false,"rook",pieces);
        ChessPiece bPawn1 = new ChessPiece(0,1,false,"pawn",pieces);
        ChessPiece bPawn2 = new ChessPiece(1,1,false,"pawn",pieces);
        ChessPiece bPawn3 = new ChessPiece(2,1,false,"pawn",pieces);
        ChessPiece bPawn4 = new ChessPiece(3,1,false,"pawn",pieces);
        ChessPiece bPawn5 = new ChessPiece(4,1,false,"pawn",pieces);
        ChessPiece bPawn6 = new ChessPiece(5,1,false,"pawn",pieces);
        ChessPiece bPawn7 = new ChessPiece(6,1,false,"pawn",pieces);
        ChessPiece bPawn8 = new ChessPiece(7,1,false,"pawn",pieces);

        ChessPiece wRook = new ChessPiece(0,7,true,"rook",pieces);
        ChessPiece wKnight = new ChessPiece(1,7,true,"knight",pieces);
        ChessPiece wBishop = new ChessPiece(2,7,true,"bishop",pieces);
        ChessPiece wQueen = new ChessPiece(3,7,true,"queen",pieces);
        ChessPiece wKing = new ChessPiece(4,7,true,"king",pieces);
        ChessPiece wBishop2 = new ChessPiece(5,7,true,"bishop",pieces);
        ChessPiece wKnight2 = new ChessPiece(6,7,true,"knight",pieces);
        ChessPiece wRook2 = new ChessPiece(7,7,true,"rook",pieces);
        ChessPiece wPawn1 = new ChessPiece(0,6,true,"pawn",pieces);
        ChessPiece wPawn2 = new ChessPiece(1,6,true,"pawn",pieces);
        ChessPiece wPawn3 = new ChessPiece(2,6,true,"pawn",pieces);
        ChessPiece wPawn4 = new ChessPiece(3,6,true,"pawn",pieces);
        ChessPiece wPawn5 = new ChessPiece(4,6,true,"pawn",pieces);
        ChessPiece wPawn6 = new ChessPiece(5,6,true,"pawn",pieces);
        ChessPiece wPawn7 = new ChessPiece(6,6,true,"pawn",pieces);
        ChessPiece wPawn8 = new ChessPiece(7,6,true,"pawn",pieces);


        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true);
        JPanel panel = new JPanel(){
            @Override
            public void paint(Graphics g){
                boolean white = true;
                Color brown = new Color(92, 64, 51);
                Color lightBrown = new Color(186,164,132);
                //drawing board here
                for(int y = 0; y<8; y++){
                    for(int x = 0; x<8; x++){
                        if(white){
                            g.setColor(lightBrown);
                        }
                        else{
                            g.setColor(brown);
                        }
                        g.fillRect(x*64, y*64, 64, 64);
                        white = !white;
                    }
                    white = !white;
                }
                //drawing pieces here
                Map<String, Integer> pieceIndexMap = new HashMap<>();
                pieceIndexMap.put("king", 0);
                pieceIndexMap.put("queen", 1);
                pieceIndexMap.put("bishop", 2);
                pieceIndexMap.put("knight", 3);
                pieceIndexMap.put("rook", 4);
                pieceIndexMap.put("pawn", 5);
        

                Iterator<ChessPiece> iterator = pieces.iterator();
                while (iterator.hasNext()) {
                    ChessPiece pTemp = iterator.next();
                    String pieceName = pTemp.name.toLowerCase();
                    int index = pieceIndexMap.getOrDefault(pieceName, -1);
                    
                    if (!pTemp.isWhite) {
                        index += 6;
                    }
                    
                    if (index >= 0 && index < images.length) {
                        g.drawImage(images[index], pTemp.x2, pTemp.y2, this);
                    }
                }
            }
        };


        frame.add(panel);
        //mouse listener and mouse motion listener are just stuff i found online on how to move the pieces using your mouse
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e){
            }
            @Override
            public void mousePressed(MouseEvent e){
                selectedChessPiece = getPiece(e.getX(), e.getY());
            }
            @Override
            public void mouseReleased(MouseEvent e){
                selectedChessPiece.move(e.getX()/64, e.getY()/64);
                frame.repaint();
                //use javas random library to get a rand int x, then iterate through hashset x times to select that piece, then move that piece
                Random random = new Random();
                //choose from 0-15 because 16 black pieces -> for now this is going to be imperfect, since pieces being taken would mean less pieces to choose from and wont 
                //always be 15. In final version i will probably refactor the code to have a hashset for black pieces and white pieces so that i can just pass blackSet.size()
                //instead of 15.
                int x = random.nextInt(15); 
                Iterator<ChessPiece> iterator = pieces.iterator();
                ChessPiece temp = null;
                while(x >= 0){
                    temp = iterator.next();
                    x--;
                }
                //make sure that temp is black
                while(temp.isWhite == true){
                    temp = iterator.next();
                }
                //temp is a random piece now
                temp.y2 += 128;
                frame.repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e){
            }
            @Override
            public void mouseExited(MouseEvent e){
            }
        });
        frame.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e){
                if(selectedChessPiece!= null){
                    selectedChessPiece.x2 = e.getX()-32;
                    selectedChessPiece.y2 = e.getY()-32;
                    frame.repaint();
                }
            }
            public void mouseMoved(MouseEvent e){
            }
        });
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }
    public static ChessPiece getPiece(int x, int y){
        int xPosition = x/64;
        int yPosition = y/64;
        Iterator<ChessPiece> i = pieces.iterator();
        while(i.hasNext()){
            ChessPiece pTemp = i.next();
            if(pTemp.x == xPosition && pTemp.y == yPosition){
                return pTemp;
            }
        }
        return null;
    }
}