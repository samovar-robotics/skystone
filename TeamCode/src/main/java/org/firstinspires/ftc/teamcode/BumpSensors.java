package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BumpSensors {
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private final com.qualcomm.robotcore.hardware.TouchSensor frontTouch;
    private final com.qualcomm.robotcore.hardware.TouchSensor backTouch;

    public BumpSensors(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;

        frontTouch = hardwareMap.touchSensor.get("frontTouch");
        backTouch = hardwareMap.touchSensor.get("backTouch");
    }

    public boolean isBackTouched() {
        boolean result = backTouch.isPressed();
        telemetry.addData("Back Bump", result);
        return result;
    }

    public boolean isFrontTouched() {
        boolean result = frontTouch.isPressed();
        telemetry.addData("Front Bump", result);
        return result;
    }

}
