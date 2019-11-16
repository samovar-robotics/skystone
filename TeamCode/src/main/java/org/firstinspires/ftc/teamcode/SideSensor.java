package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SideSensor {
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private final TouchSensor sideTouch;

    SideSensor(OpMode opMode){
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;
        this.sideTouch = hardwareMap.touchSensor.get("SideSensor");


    }
    public boolean isTouched() {
        boolean result = sideTouch.isPressed();
        telemetry.addData("Back Bump", result);
        return result;
    }

}
