package floppy_bird;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FlappyBird extends JFrame {
    private int x, y, vy;
    private int gapX, gapY;
    private boolean gameover;
    private Timer timer;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    public FlappyBird() {
        super("Flappy Bird");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        x = 100;
        y = HEIGHT / 2;
        vy = 0;
        gapX = 200;
        gapY = 100;
        gameover = false;

        timer = new Timer(20, new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               update();
               repaint();
           }
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    vy = -10;
                }
            }
        });
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.ORANGE);
        g.fillRect(gapX, 0, 50, gapY);
        g.fillRect(gapX, gapY + 150, 50, HEIGHT -gapY - 150);

        g.setColor(Color.RED);
        g.fillOval(x - 10, y - 10, 20, 20);

        if (gameover) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over!", 150, HEIGHT / 2);
        }
    }

    public void update() {
        if (gameover) {
            return;
        }

        vy += 1;
        y += vy;

        if (x > gapX - 10 && x < gapX + 50 + 10 &&
                (y < gapY + 10 || y > gapY + 150 - 10)) {
            gameover = true;
        }

        if (y < 10 || y > HEIGHT -10) {
            gameover = true;
        }
    }
}
