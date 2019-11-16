package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SideArm {
    HardwareMap hardwareMap;
    Telemetry telemetry;

    Servo servo;

    SideArm(OpMode opMode){
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;

        this.servo = hardwareMap.servo.get("SideServo");

        init();
    }

    void init(){
        this.servo.setPosition(0);
    }

    void goUp(){
        this.servo.setPosition(0);
    }

    void goDown(){
        this.servo.setPosition(1);
    }

}
