package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="NEW AUTO TEST BLOCK GRAB", group = "TESTTT")
public class BlockAutoRed extends LinearOpMode {
    DirectionalDrive drive;
    RotationSensor rotationSensor;
    DistanceChecker distanceChecker;
    SideBlockGrabber sideBlockGrabber;
    double DISTANCEFROMBLOCK = 2;

    public void initializeHardware(){
        drive = new DirectionalDrive(this);
        rotationSensor = new RotationSensor(this);
        distanceChecker = new DistanceChecker(this);
        sideBlockGrabber = new SideBlockGrabber(this);
        telemetry.addLine("Initialized Hardware");
        telemetry.addLine("Don’t use “beef stew” as a computer password. It’s not stroganoff.");
    }
    @Override
    public void runOpMode() throws InterruptedException {
        initializeHardware();
        waitForStart();
        while (distanceChecker.getINCHES()>DISTANCEFROMBLOCK){
            drive.goRight(1f);
        }
        drive.stop();
        while (rotationSensor.getTurningDegrees()<-10){
            drive.controlMotorsIndividually(.35f, .35f, 0, 0);
        }
        while (rotationSensor.getTurningDegrees()>10){
            drive.controlMotorsIndividually(0, 0, .35f, .35f);
        }
        drive.stop();
        while (distanceChecker.getINCHES()>.25){
            drive.goRight(.25f);
        }
        drive.stop();
        sideBlockGrabber.grab();
        sleep(600);
        drive.goLeft(1f);
        sleep(400);
        drive.goForward(1);
        sleep(1500);
        drive.stop();



    }
}
