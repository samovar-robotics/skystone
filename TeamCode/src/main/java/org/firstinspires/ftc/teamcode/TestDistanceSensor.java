package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="test distance", group = "tests")
public class TestDistanceSensor extends OpMode {
    DistanceChecker distanceChecker;
    @Override
    public void init() {
        distanceChecker = new DistanceChecker(this);
    }

    @Override
    public void loop() {
        telemetry.addData("Distance iN Inches", this.distanceChecker.getInches());
    }
}
