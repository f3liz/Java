/*
Felix Chen
SDEV 218
Topics: loops and graphics

This program will display a snowman with randoms colors and snow falling
 */

import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.Color;
import java.util.*;

public class Snowman extends GraphicsProgram{

    public void run() {
        snowman();
    }

    public void drawHead() {
        GOval head = new GOval(320, 80, 100, 100);
        head.setFilled(true);
        Random num = new Random();
        int red = num.nextInt(256);
        int green = num.nextInt(256);
        int blue = num.nextInt(256);
        Color color = new Color(red, green, blue);
        head.setColor(color);
        add(head);
    }

    public void drawBody() {
        GOval body = new GOval(295, 150, 150, 150);
        body.setFilled(true);
        Random num = new Random();
        int red = num.nextInt(256);
        int green = num.nextInt(256);
        int blue = num.nextInt(256);
        Color color = new Color(red, green, blue);
        body.setColor(color);
        add(body);
    }

    public void drawBottom() {
        GOval bottom = new GOval(270, 230, 200, 200);
        bottom.setFilled(true);
        Random num = new Random();
        int red = num.nextInt(256);
        int green = num.nextInt(256);
        int blue = num.nextInt(256);
        Color color = new Color(red, green, blue);
        bottom.setColor(color);
        add(bottom);
    }

    public void drawFace() {
        GOval rightEye = new GOval(380, 105, 15, 15);
        rightEye.setFilled(true);
        rightEye.setColor(Color.black);

        GOval leftEye = new GOval(345, 105, 15, 15);
        leftEye.setFilled(true);
        leftEye.setColor(Color.black);

        GOval nose = new GOval(365, 125, 10, 10);
        nose.setFilled(true);
        nose.setColor(Color.orange);

        add(rightEye);
        add(leftEye);
        add(nose);
    }

    public void drawArms() {
        GLine leftArm = new GLine(220, 140, 320, 200);
        leftArm.setColor(Color.black);

        GLine rightArm = new GLine(520, 140, 420, 200);
        rightArm.setColor(Color.black);

        add(rightArm);
        add(leftArm);
    }

    public void drawSnow() {
        GOval snowOne = new GOval(170 , 0, 20, 20);
        snowOne.setFilled(true);
        snowOne.setColor(Color.white);

        GOval snowTwo = new GOval(500, 0, 20, 20);
        snowTwo.setFilled(true);
        snowTwo.setColor(Color.white);

        GOval snowThree = new GOval(100, 0, 20, 20);
        snowThree.setFilled(true);
        snowThree.setColor(Color.white);

        GOval snowFour = new GOval(600, 0, 20, 20);
        snowFour.setFilled(true);
        snowFour.setColor(Color.white);

        add(snowOne);
        add(snowTwo);
        add(snowThree);
        add(snowFour);

        while(true) {
            snowOne.move(0, 10);
            snowTwo.move(0, 12);
            snowThree.move(0, 8);
            snowFour.move(0, 14);

            if (snowOne.getY() > 500) {
                snowOne.setLocation(snowOne.getX(), 0);
            }

            if (snowTwo.getY() > 500) {
                snowTwo.setLocation(snowTwo.getX(), 0);
            }

            if (snowThree.getY() > 500) {
                snowThree.setLocation(snowThree.getX(), 0);
            }

            if (snowFour.getY() > 500) {
                snowFour.setLocation(snowFour.getX(), 0);
            }
            pause(60);


        }

    }

    public void snowman() {
        setBackground(Color.cyan);
        drawBottom();
        drawBody();
        drawHead();
        drawFace();
        drawArms();
        drawSnow();
    }
    public static void main(String[] args) {
        new Snowman().start();
    }
}

/*
What parts of the assignment were the easiest to complete?
I think overall the whole assignment was pretty easy to complete.

What are some things that went wrong when completing this assignment?
Just trying to figure out the x and y for drawing the objects was a little time consuming.

How did you deal with these setbacks?
A lot of trial and error.

About how many hours did you spend working on this assignment?
Less than an hour.
 */