package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TrayGrabber {
    double LET_GO = 0;
    double GRAB = 0.5;
    Servo servo;
    Servo servo2;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;

    public TrayGrabber(OpMode opMode) {

        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;

        servo = hardwareMap.servo.get("trayGrabberL");
        servo2 = hardwareMap.servo.get("trayGrabberR");

        letGo();
    }

    void letGo() {
        servo.setPosition(LET_GO);
        servo2.setPosition(LET_GO);
    }

    void grab() {
        servo2.setPosition(GRAB);
        servo.setPosition(GRAB);
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
