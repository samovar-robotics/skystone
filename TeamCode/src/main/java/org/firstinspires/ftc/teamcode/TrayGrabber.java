package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TrayGrabber {
    double LET_GO = 0;
    double GRAB = 0.5;
    Servo servoLeft;
    Servo servoRight;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;

    public TrayGrabber(OpMode opMode) {

        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;

        servoLeft = hardwareMap.servo.get("trayGrabberL");
        servoRight = hardwareMap.servo.get("trayGrabberR");

        servoLeft.setDirection(Servo.Direction.FORWARD);
        servoRight.setDirection(Servo.Direction.REVERSE);

        letGo();
    }

    void letGo() {
        servoLeft.setPosition(LET_GO);
        servoRight.setPosition(LET_GO);
    }

    void grab() {
        servoRight.setPosition(GRAB);
        servoLeft.setPosition(GRAB);
    }


    public void operate(boolean isPressed){
        if(isPressed){
            telemetry.addLine("Grabbing tray");
            grab();
        }
        else {
            telemetry.addLine("Letting operate of tray");
            letGo();
        }
    }
}
