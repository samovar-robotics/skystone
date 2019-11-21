package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Whiskers {

    public Whiskers(OpMode opMode) {

        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;

        leftServo = hardwareMap.servo.get("whiskerL");
        rightServo = hardwareMap.servo.get("whiskerR");

        open();
    }

    public void operate(boolean isPressed) {
        if (isPressed) {
            close();
        }
        else {
            open();
        }
    }

    ////////////////////////////////////////

    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private Servo leftServo;
    private Servo rightServo;

    private final float OPEN = 0.0f;
    private final float CLOSED = 0.5f;

    private void open() {
        telemetry.addLine("opening whiskers");
        leftServo.setPosition(OPEN);
        rightServo.setPosition(1.0f-OPEN);
    }

    private void close() {
        telemetry.addLine("closing whiskers");
        leftServo.setPosition(CLOSED);
        rightServo.setPosition(1.0f-CLOSED);
    }
}

