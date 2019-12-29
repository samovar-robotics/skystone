package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test Distance Sensor", group = "tests")
public class TestDistanceSensors extends OpMode {

    private DistanceChecker distanceChecker;

    @Override
    public void init() {
        distanceChecker = new DistanceChecker(this);
    }

    @Override
    public void loop() {
        telemetry.addData("Distance inch", distanceChecker.getInches());
        telemetry.addData("Distance cm  ", distanceChecker.getCM());

    }
}

