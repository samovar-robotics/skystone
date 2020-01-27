package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Whiskers {
    private boolean holdWiskersClosed;

    public Whiskers(OpMode opMode) {

        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;

        leftServo = hardwareMap.servo.get("whiskerL");
        rightServo = hardwareMap.servo.get("whiskerR");
        holdWiskersClosed = false;
    }

    public void operate(Gamepad gamepad) { // Working close lock
        if (gamepad.y) {
            holdWiskersClosed = true;
        } else if (gamepad.a) {
            holdWiskersClosed = false;
        }

        if (holdWiskersClosed) {
            telemetry.addData("Locked closed", true);
            movingClosed();
        } else {
            if (gamepad.left_bumper || gamepad.right_bumper) {
                grab(gamepad.left_bumper, gamepad.right_bumper);
            } else {
                open();
            }
        }
    }

    ////////////////////////////////////////

    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private Servo leftServo;
    private Servo rightServo;

    private final float OPEN = 0.5f;
    private final float CLOSED = 0.0f;

    private void open() {
        telemetry.addLine("opening whiskers");
        leftServo.setPosition(OPEN);
        rightServo.setPosition(1.0f-OPEN);
    }

    private void movingClosed() {
        float closeAmount =  (CLOSED+ .16f);
        leftServo.setPosition(closeAmount);
        rightServo.setPosition(1.0f-closeAmount);
    }

    private void grab(boolean left, boolean right){
        telemetry.addData("whiskers grabbing left", left);
        telemetry.addData("whiskers grabbing right", right);
        float closeAmount =  (CLOSED+ .16f);
        if(left) {
            leftServo.setPosition(closeAmount);
        }
        if(right){
            rightServo.setPosition(1.0f-closeAmount);
        }
    }

    private void foldedAway() {
        telemetry.addLine("folding away whiskers");
        leftServo.setPosition(CLOSED);
        rightServo.setPosition(1.0f-CLOSED);
    }
}

