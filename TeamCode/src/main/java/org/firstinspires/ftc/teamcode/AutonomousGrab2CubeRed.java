package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "> Autonomous Grab 2 Cube Red", group = "competition")
public class AutonomousGrab2CubeRed extends LinearOpMode {
    Drive drive = null;
    DistanceChecker distanceChecker = null;

    SideBlockGrabber sideBlockGrabber;

    private void initializeHardware() {
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
        driveTowardCubes( .5f, 1);

        drive.stop();
        telemetry.addLine("Stopping to ponder the meaning of life");
        pause();

        sideBlockGrabber.down();
        pause();
        pause();

        // crab back
        crabForTime(1.5, -.5f, 0, 2);
        drive.stop();
        pause();

        // go to bridge
        resetStartTime();
        crabForTime(3.5, 0, -0.5f, 2.25f);
        drive.stop();
        pause();
        sideBlockGrabber.up();
        pause();
        pause();
        resetStartTime();
        drive.stop();
        pause();
        resetStartTime();
        crabForTime(4, 0, 0.6f, 2);
        drive.stop();
        pause();
        resetStartTime();
        driveTowardCubes(.3f, 1);
        resetStartTime();
        drive.stop();
        sleep(100);
        sideBlockGrabber.down();
        pause();
        pause();
        crabForTime(1.5, -.6f, 0f, 2);
        crabForTime(4,0, -0.5f, 2);
        drive.stop();
        sideBlockGrabber.up();
        pause();
        pause();
        crabForTime(2,0,.5f, 1);
    }

    private void crabForTime(double seconds, float x, float y, float multiplier) {
        resetStartTime();
        while(withinTimeBox(seconds)){
            drive.autonomousCorrectedDrive(x,y, multiplier);
            telemetry.update();
        }
    }

    private void driveTowardCubes( float v, int i) {
        while (withinTimeBox(4) && cubeTooFar()) {
            drive.autonomousCorrectedDrive(v, 0, i);
            telemetry.update();
        }
    }


    private boolean cubeTooFar() {
        return distanceChecker.getInches() > 1.5;
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
