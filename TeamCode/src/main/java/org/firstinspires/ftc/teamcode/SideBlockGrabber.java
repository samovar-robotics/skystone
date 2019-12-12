package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SideBlockGrabber {
    private double GRABPOSITION = 90;
    private double UPPOSITION = 0;

    Servo servo;

    HardwareMap hardwareMap;
    Telemetry telemetry;

    SideBlockGrabber(OpMode opMode){
        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;
        init();
    }

    public void init(){
        servo = hardwareMap.servo.get("sideGrabberServo");
        servo.setPosition(UPPOSITION);
    }

    public void grab(){
        servo.setPosition(GRABPOSITION);
    }
    public void goUp(){
        servo.setPosition(UPPOSITION);
    }
}
