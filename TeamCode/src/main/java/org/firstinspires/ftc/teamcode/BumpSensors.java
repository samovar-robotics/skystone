package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BumpSensors {
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private final TouchSensor frontTouch;
    private final TouchSensor backTouch;

    public BumpSensors(OpMode opMode) {
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;

        frontTouch = hardwareMap.touchSensor.get("sideTouch");
        backTouch = hardwareMap.touchSensor.get("frontTouch");
    }

    public boolean isSideTouched() {
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
