package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SideBlockGrabber  {
    HardwareMap hardwareMap;
    Servo servo;
    Telemetry telemetry;

    SideBlockGrabber(OpMode opMode){
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;
        servo = hardwareMap.servo.get("SideGrabberServo");
        goUp();
    }
    double GRABDISTANCE = 90;
    double UPDISTANCE = 0;

    public void goUp(){
        servo.setPosition(UPDISTANCE);
    }
    public void grab(){
        servo.setPosition(GRABDISTANCE);
    }
}
