package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Test Crab Orientation Checker", group = "tests")
public class testContinousTest extends LinearOpMode {
    Drive drive = null;
    //DistanceChecker distanceChecker = null;

    public void initializeHardware() {
        drive = new Drive(this);
        drive.lockHeading();
        telemetry.addLine("Initialized Hardware");
    }

    @Override
    public void runOpMode() throws InterruptedException {

        initializeHardware();

        waitForStart();
        telemetry.addLine("Start pressed");
        // crab to cube

        drive.lockHeading();
        resetStartTime();
        telemetry.addLine("Going forward");
        while (opModeIsActive()) {
            drive.Crab(-.4f);
            telemetry.update();
        }
    }

}
