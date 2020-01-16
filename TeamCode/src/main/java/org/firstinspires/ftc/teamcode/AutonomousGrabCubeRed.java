package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "> Autonomous Grab Cube Red", group = "competition")
public class AutonomousGrabCubeRed extends LinearOpMode {
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
        while (withinTimeBox(4) && cubeTooFar()) {
            drive.autonomousCorrectedDrive(.5f, 0, 1);
            telemetry.update();
        }

        drive.stop();
        telemetry.addLine("Stopping to ponder the meaning of life");
        pause();

        sideBlockGrabber.down();
        pause();
        pause();

       // crab back
        resetStartTime();
        while(withinTimeBox(1.5)){
            drive.autonomousCorrectedDrive(-.5f, 0, 2);
            telemetry.update();
        }
        drive.stop();
        pause();

       // go to bridge
        resetStartTime();

        while (withinTimeBox(2.5)){
            telemetry.update();
            drive.autonomousCorrectedDrive(0, -.5f,2.25f);
        }
        drive.stop();
        pause();
        sideBlockGrabber.up();
        pause();
        pause();
        resetStartTime();
        while (withinTimeBox(1.5)){
            drive.autonomousCorrectedDrive(0, .5f, 1);
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
