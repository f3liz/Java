import acm.program.*;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Name: Felix Chen
 * Core Topics: Creating Arrays of Objects, Passing Arrays of Objects as Parameters, Returning Arrays of Objects
 * from Methods, Determining if an Array of Objects collides with another object
 */
public class ObjectArrays extends GraphicsProgram {

    public static final int APPLICATION_HEIGHT = 800;
    public static final int APPLICATION_WIDTH = 1200;

    public static final int TARGET_SIZE = 100;

    GImage cow; // declare cow here so it is visible in all methods like keyPressed

    public void run() {

        // TODO: call createTargets
        GRect[] array = createTargets(5);

        // TODO: create cow object
        createCow();

        // add key Listener
        addKeyListeners();

        // TODO: call animateTargets
        animateTargets(array, 5);
    }

    /**
     * This method creates an array of Solid Yellow GRect objects. These objects will
     * be animated and represent hay bales. The array size is passed in as a
     * parameter
     *
     * @param size of objects in array
     * @return an array of Solid Yellow GRect objects
     */
    public GRect[] createTargets(int size) {
        //TODO: add code here
        GRect[] array = new GRect[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new GRect(randomCoordinate('x'), randomCoordinate('y'), TARGET_SIZE, TARGET_SIZE/2);
            array[i].setFilled(true);
            array[i].setFillColor(Color.YELLOW); // black outline
            add(array[i]);
        }
        return array;
    }

    /**
     * This method generates an integer coordinate location that is in the current
     * window space.  This method expects an 'x' or 'y' as a coordinate parameter.
     * If 'x' or 'y' is not passed an IllegalArgumentException is thrown.
     *
     * @param coordinate indicates whether x or y coordinate is desired
     * @return an integer coordinate location
     */
    public int randomCoordinate(char coordinate) {
        if (coordinate != 'x' && coordinate != 'y') {
            throw new IllegalArgumentException();
        }

        if (coordinate == 'x') {
            return new Random().nextInt(APPLICATION_WIDTH - TARGET_SIZE);
        } else if (coordinate == 'y') {
            return new Random().nextInt(APPLICATION_HEIGHT - TARGET_SIZE / 2);
        }
        return 0;
    }

    /**
     * This method animates the array of targets and checks if a cow has collided with
     * one of the targets.  If so, the target is made invisible. The animation continues until the cow
     * has collided with size targets
     *
     * @param targets
     */
    public void animateTargets(GRect[] targets, int size) {
        // TODO: add code here
        int collided = 0;
        while(collided < size) {
            for (int i = 0; i < targets.length; i++) {
                if (cow.getBounds().intersects(targets[i].getBounds()) && targets[i].isVisible()) {
                    targets[i].setVisible(false);
                    collided++;
                    System.out.println("Cow collides with GRect " + collided);
                }
            }
            pause(50);
        }
        System.out.println("All hay eaten");
        GLabel label = new GLabel("All Hay Eaten!!!");
        label.setFont("Helvetica-50");
        add(label, APPLICATION_WIDTH/3, APPLICATION_HEIGHT/2);
    }

    /**
     * This method creates a cow GImage object that the user can move with the up,down,left, and
     * right arrows
     */
    public void createCow() {
        // TODO: add code here
        cow = new GImage("cow1.png");
        add(cow, 100, 100);
    }

    /**
     * This method moves the cow up, down, left, and right based the keyboard arrow pressed
     *
     * @param e KeyEvent for key pressed
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            cow.move(0, -10);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            cow.move(0, 10);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cow.move(-10, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cow.move(10, 0);
        }
    }

    /**
     * Launches an empty application window
     *
     * @param args not used
     */
    public static void main(String[] args) {
        new ObjectArrays().start();
    }
}

