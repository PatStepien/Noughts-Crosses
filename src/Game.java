import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.MouseEvent;
import java.awt.MouseInfo;
import java.awt.Component;
import java.util.Random;


public class Game extends JFrame implements MouseInputListener {

    Point cursorLocation;
    boolean gridCreated = false;
    boolean addCircle = false;
    boolean playerMove = true;
    boolean AIWon = false;
    boolean playerWon = false;
    Random random;
    int AIOpponentMoveLocation;
    int [] locations = {0,1,2,3,4,5,6,7,8};
    int AILocationChosen;

    //Variables for crosses locations
    int x1Line1Right = 750;
    int x2Line1Right = 700;
    int x1Line2Right = 650;
    int x2Line2Right = 750;

    int x1Line1Middle = 550;
    int x2Line1Middle = 500;
    int x1Line2Middle = 450;
    int x2Line2Middle = 550;

    int x1Line1Left = 350;
    int x2Line1Left = 300;
    int x1Line2Left = 250;
    int x2Line2Left = 350;

    int y1Line1Bottom = 650;
    int y2Line1Bottom = 800;
    int y1Line2Bottom = 650;
    int y2Line2Bottom = 800;

    int y1Line1Middle = 450;
    int y2Line1Middle = 600;
    int y1Line2Middle = 450;
    int y2Line2Middle = 600;

    int y1Line1Top = 250;
    int y2Line1Top = 400;
    int y1Line2Top = 250;
    int y2Line2Top = 400;



    Game(){

        //Creating frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addMouseListener(this);
        random = new Random();




    }

        public void checkWin() {

        if (locations[0] == -2 && locations[1] == -2 && locations[2] == -2) {
            AIWon = true;
        }
        if (locations[0] == -2 && locations[3] == -2 && locations[6] == -2) {
            AIWon = true;
        }

        if (locations[0] == -2 && locations[4] == -2 && locations[8] == -2) {
            AIWon = true;
        }
        if (locations[1] == -2 && locations[4] == -2 && locations[7] == -2) {
            AIWon = true;
        }
        if (locations[2] == -2 && locations[5] == -2 && locations[8] == -2) {
            AIWon = true;
        }
        if (locations[2] == -2 && locations[4] == -2 && locations[6] == -2) {
            AIWon = true;
        }
        if (locations[3] == -2 && locations[4] == -2 && locations[5] == -2) {
            AIWon = true;
        }
        if (locations[6] == -2 && locations[7] == -2 && locations[8] == -2) {
            AIWon = true;
        }

        if (locations[0] == -1 && locations[1] == -1 && locations[2] == -1) {
            playerWon = true;
        }

        if (locations[0] == -1 && locations[3] == -1 && locations[6] == -1) {
            playerWon = true;
        }

        if (locations[0] == -1 && locations[4] == -1 && locations[8] == -1) {
            playerWon = true;
        }
        if (locations[1] == -1 && locations[4] == -1 && locations[7] == -1) {
            playerWon = true;
        }
        if (locations[2] == -1 && locations[5] == -1 && locations[8] == -1) {
            playerWon = true;
        }
        if (locations[2] == -1 && locations[4] == -1 && locations[6] == -1) {
            playerWon = true;
        }
        if (locations[3] == -1 && locations[4] == -1 && locations[5] == -1) {
            playerWon = true;
        }
        if (locations[6] == -1 && locations[7] == -1 && locations[8] == -1) {
            playerWon = true;
        }
    }

        @Override
        public void paint (Graphics g){

        if (!gridCreated) {
            //Vertical
            g.drawLine(400, 200, 400, 800);
            g.drawLine(600, 200, 600, 800);
            //Horizontal
            g.drawLine(200, 400, 800, 400);
            g.drawLine(200, 600, 800, 600);
            gridCreated = true;
        }
        if (addCircle && playerMove) {

            //Location 1 top left
            if (cursorLocation.y < 400 && cursorLocation.y > 200 && cursorLocation.x > 200 && cursorLocation.x < 400 && locations[0] != -1 && locations[0] != -2) {
                g.drawOval(250, 250, 100, 100);
                locations[0] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 1 top middle
            if (cursorLocation.y < 400 && cursorLocation.y > 200 && cursorLocation.x >= 400 && cursorLocation.x < 600 && locations[1] != -1 && locations[1] != -2) {
                g.drawOval(450, 250, 100, 100);
                locations[1] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 2 top right
            if (cursorLocation.y < 400 && cursorLocation.y > 200 && cursorLocation.x >= 600 && cursorLocation.x < 800 && locations[2] != -1 && locations[2] != -2) {
                g.drawOval(650, 250, 100, 100);
                locations[2] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 3 middle left
            if (cursorLocation.y < 600 && cursorLocation.y >= 400 && cursorLocation.x > 200 && cursorLocation.x < 400 && locations[3] != -1 && locations[3] != -2) {
                g.drawOval(250, 450, 100, 100);
                locations[3] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 4 middle middle
            if (cursorLocation.y < 600 && cursorLocation.y >= 400 && cursorLocation.x >= 400 && cursorLocation.x < 600 && locations[4] != -1 && locations[4] != -2) {
                g.drawOval(450, 450, 100, 100);
                locations[4] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 5 middle left
            if (cursorLocation.y < 600 && cursorLocation.y >= 400 && cursorLocation.x >= 600 && cursorLocation.x < 800 && locations[5] != -1 && locations[5] != -2) {
                g.drawOval(650, 450, 100, 100);
                locations[5] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 6 bottom left
            if (cursorLocation.y < 800 && cursorLocation.y >= 600 && cursorLocation.x > 200 && cursorLocation.x < 400 && locations[6] != -1 && locations[6] != -2) {
                g.drawOval(250, 650, 100, 100);
                locations[6] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 7 bottom middle
            if (cursorLocation.y < 800 && cursorLocation.y >= 600 && cursorLocation.x >= 400 && cursorLocation.x < 600 && locations[7] != -1 && locations[7] != -2) {
                g.drawOval(450, 650, 100, 100);
                locations[7] = -1;
                playerMove = false;
                AIMove();
            }
            //Location 8 bottom right
            if (cursorLocation.y < 800 && cursorLocation.y >= 600 && cursorLocation.x >= 600 && cursorLocation.x < 800 && locations[8] != -1 && locations[8] != -2) {
                g.drawOval(650, 650, 100, 100);
                locations[8] = -1;
                playerMove = false;
                AIMove();
            }
        }
        if (!playerMove) {
            AIOpponentMoveLocation = random.nextInt(9);
            AILocationChosen = locations[AIOpponentMoveLocation];
            while (!playerMove) {
                //Location 0 top left
                if (AILocationChosen == 0) {
                    g.drawLine(x1Line1Left, y1Line1Top, x2Line1Left, y2Line1Top);
                    g.drawLine(x1Line2Left, y1Line2Top, x2Line2Left, y2Line2Top);
                    locations[0] = -2;
                    playerMove = true;

                }
                //Location 1 top middle
                if (AILocationChosen == 1) {
                    g.drawLine(x1Line1Middle, y1Line1Top, x2Line1Middle, y2Line1Top);
                    g.drawLine(x1Line2Middle, y1Line2Top, x2Line2Middle, y2Line2Top);
                    locations[1] = -2;
                    playerMove = true;
                }
                //Location 2 top right
                if (AILocationChosen == 2) {
                    g.drawLine(x1Line1Right, y1Line1Top, x2Line1Right, y2Line1Top);
                    g.drawLine(x1Line2Right, y1Line2Top, x2Line2Right, y2Line2Top);
                    locations[2] = -2;
                    playerMove = true;
                }
                //Location 3 middle left
                if (AILocationChosen == 3) {
                    g.drawLine(x1Line1Left, y1Line1Middle, x2Line1Left, y2Line1Middle);
                    g.drawLine(x1Line2Left, y1Line2Middle, x2Line2Left, y2Line2Middle);
                    locations[3] = -2;
                    playerMove = true;
                }
                //Location 4 middle middle
                if (AILocationChosen == 4) {
                    g.drawLine(x1Line1Middle, y1Line1Middle, x2Line1Middle, y2Line1Middle);
                    g.drawLine(x1Line2Middle, y1Line2Middle, x2Line2Middle, y2Line2Middle);
                    locations[4] = -2;
                    playerMove = true;
                }
                //Location 5 middle right
                if (AILocationChosen == 5) {
                    g.drawLine(x1Line1Right, y1Line1Middle, x2Line1Right, y2Line1Middle);
                    g.drawLine(x1Line2Right, y1Line2Middle, x2Line2Right, y2Line2Middle);
                    locations[5] = -2;
                    playerMove = true;
                }
                //Location 6 bottom left
                if (AILocationChosen == 6) {
                    g.drawLine(x1Line1Left, y1Line1Bottom, x2Line1Left, y2Line1Bottom);
                    g.drawLine(x1Line2Left, y1Line2Bottom, x2Line2Left, y2Line2Bottom);
                    locations[6] = -2;
                    playerMove = true;
                }
                //Location 7 bottom middle
                if (AILocationChosen == 7) {
                    g.drawLine(x1Line1Middle, y1Line1Bottom, x2Line1Middle, y2Line1Bottom);
                    g.drawLine(x1Line2Middle, y1Line2Bottom, x2Line2Middle, y2Line2Bottom);
                    locations[7] = -2;
                    playerMove = true;
                }
                //Location 8 bottom right
                if (AILocationChosen == 8) {
                    g.drawLine(x1Line1Right, y1Line1Bottom, x2Line1Right, y2Line1Bottom);
                    g.drawLine(x1Line2Right, y1Line2Bottom, x2Line2Right, y2Line2Bottom);
                    locations[8] = -2;
                    playerMove = true;
                }
                if (AILocationChosen == -1 || AILocationChosen == -2) {
                    for (int i = 0; i < 9; i++) {
                        AILocationChosen = locations[i];
                        if (AILocationChosen != -1 && AILocationChosen != -2) {
                            break;
                        }
                    }
                }

            }
        }
        checkWin();
        if (AIWon) {
            g.drawString("You lost", 60, 60);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        if (playerWon) {
            g.drawString("You won", 60, 60);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

        public void AIMove () {

        Graphics g = this.getGraphics();
        paint(g);
    }

//MouseInputListener methods
        @Override
        public void mouseClicked (MouseEvent e){
        addCircle = true;
        cursorLocation = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(cursorLocation, e.getComponent());
        Graphics g = this.getGraphics();
        paint(g);
    }

        @Override
        public void mousePressed (MouseEvent e){

    }

        @Override
        public void mouseReleased (MouseEvent e){

    }

        @Override
        public void mouseEntered (MouseEvent e){

    }

        @Override
        public void mouseExited (MouseEvent e){

    }

        @Override
        public void mouseDragged (MouseEvent e){

    }

        @Override
        public void mouseMoved (MouseEvent e){

    }

}
