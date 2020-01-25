package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "> Autonomous Grab 2 Cube Blue", group = "competition")
public class AutonomousGrab2CubeBlue extends LinearOpMode {
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
        drive.lockHeading();
        resetStartTime();
        telemetry.addLine("Going forward");

        // crab to cube
        driveTowardCubes( .5f, 3);

        drive.stop();
        telemetry.addLine("Stopping to ponder the meaning of life");
        pause();

        //Grab Block
        sideBlockGrabber.down();
        pause();
        pause();
        pause();
        pause();

        // crab backwards
        crabForTime(.6, -.8f, 0, 2.5f);
        drive.stop();
        pause();

        // go to bridge
        resetStartTime();
        crabForTime(1.8, 0, 0.8f, 2.3f);
        drive.stop();
        pause();

        //Release Block
        sideBlockGrabber.up();
        pause();
        pause();
        pause();
        //Go back
        resetStartTime();
        crabForTime(2, 0, -1f, 1.25f);
        drive.stop();
        pause();

        //DRIVE TOWARDS CUBE
        resetStartTime();
        driveTowardCubes(.4f, 2);
        drive.stop();

        //GRAB CUBE #2
        sleep(100);
        sideBlockGrabber.down();
        pause();
        pause();
        pause();
        pause();

        //CRAB BACK
        crabForTime(1, -.8f, 0f, 2);
        //CRAB TO BRIDGE
        crabForTime(2.5,0, 0.8f, 2);
        drive.stop();
        sideBlockGrabber.up();
        pause();
        pause();
        pause();

        crabForTime(.5,0,-.5f, 2);
//        sideBlockGrabber.down();
//        pause();
//        pause();
//        //Back
//        //crabForTime(1.5, -.5f, 0, 2);
//        drive.stop();
//        pause();
//        //To bridge
//        //crabForTime(3.5, 0, 0.5f, 2.25f);
//        drive.stop();
//        pause();
//        sideBlockGrabber.up();
//        pause();
//        pause();
//        //Leave
//        crabForTime(3, 0, -0.6f, 1);
//
//        resetStartTime();




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
        sleep(400);
    }
}
