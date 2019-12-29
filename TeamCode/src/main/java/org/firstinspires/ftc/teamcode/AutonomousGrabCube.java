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

    }

    @Override
    public void runOpMode() throws InterruptedException {

        initializeHardware();

        waitForStart();

        // crab to cube

        drive.lockHeading();
        resetStartTime();
        while (withinTimeBox(4) && cubeTooFar()) {
            drive.Crab(-.4f);
        }
        drive.stop();
        pause();

        sideBlockGrabber.down();
        pause();
        pause();

       // crab back
        drive.lockHeading();
        resetStartTime();
        while(withinTimeBox(1)){
            drive.Crab(.4f);
        }
        drive.stop();
        pause();

       // go to bridge
        resetStartTime();
        while(withinTimeBox(1)){
            drive.DriveTank(-.5f,-.5f);
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
