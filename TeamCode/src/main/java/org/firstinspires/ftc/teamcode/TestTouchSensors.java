package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test Touch Sensors")
public class TestTouchSensors extends OpMode {

    private BumpSensors bumpSensors;

    @Override
    public void init() {
        bumpSensors = new BumpSensors(this);
    }

    @Override
    public void loop() {
        if (bumpSensors.isFrontTouched()) {
            telemetry.addLine("Front!");
        } else {
            telemetry.addLine("Front clear...");
        }

        if (bumpSensors.isBackTouched()) {
            telemetry.addLine("Back!");
        } else {
            telemetry.addLine("Back clear...");
        }
    }
}
