package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "> Autonomous Grab Cube", group = "competition")
public class AutonomousGrabCube extends LinearOpMode {
    Drive drive = null;
    DistanceChecker distanceChecker = null;

    SideBlockGrabber sideBlockGrabber;

    public void initializeHardware() {
        drive = new Drive(this);
        drive.lockHeading();
        distanceChecker = new DistanceChecker(this);
        sideBlockGrabber = new SideBlockGrabber(this);
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
        while (withinTimeBox(4) && cubeTooFar()) {
            drive.Crab(-.5f);
            telemetry.update();
        }
        drive.stop();
        telemetry.addLine("Stopping to ponder the meaning of life");
        pause();

        sideBlockGrabber.down();
        pause();
        pause();

       // crab back
        drive.lockHeading();
        resetStartTime();
        while(withinTimeBox(1)){
            drive.Crab(.4f);
            telemetry.update();
        }
        drive.stop();
        pause();

       // go to bridge
        resetStartTime();
        while(withinTimeBox(1)){
            drive.DriveTank(-.5f,-.5f);
            telemetry.update();
        }
        drive.stop();
        pause();

    }


    private boolean cubeTooFar() {
        return distanceChecker.getInches() > 2;
    }

    private boolean withinTimeBox(double seconds) {
        if (getRuntime() > seconds) {
            telemetry.addData("Time-box elapsed seconds.", seconds);
            return false;
        }
        return opModeIsActive();
    }

    private void pause() {
        sleep(1000);
    }
}
