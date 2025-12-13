// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.swing.*; // gui
import java.awt.event.*; // keyboard events

public class KeyboardController extends JFrame implements KeyListener{

    private boolean buttonX = false;
    private boolean buttonY = false;
    private boolean buttonA = false;
    private boolean buttonB = false;

    public KeyboardController() {
        setTitle("Keyboard Controller GUI");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_I -> buttonY = true;
            case KeyEvent.VK_L -> buttonB = true;
            case KeyEvent.VK_M -> buttonA = true;
            case KeyEvent.VK_J -> buttonX = true;
                
            default -> {
                System.out.println("Unrecognized key: " + e.getKeyCode());
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        buttonA = false;
        buttonB = false;
        buttonX = false;
        buttonY = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean getButtonA() { return buttonA; }
    public boolean getButtonB() { return buttonB; }
    public boolean getButtonX() { return buttonX; }
    public boolean getButtonY() { return buttonY; }
    

}

