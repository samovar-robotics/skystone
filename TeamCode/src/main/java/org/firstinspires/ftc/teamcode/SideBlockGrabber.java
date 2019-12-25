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
    double GRABDISTANCE = .42069;
    double UPDISTANCE = 0;

    public double currentPosition(){
        return this.servo.getPosition();
    }
    public void goUp(){
        this.servo.setPosition(UPDISTANCE);
    }
    public void grab(){
        this.servo.setPosition(GRABDISTANCE);
    }
}
