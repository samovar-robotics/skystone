package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="TRYING OH PLEASE WORKKK", group = "TESTTT")
public class BlockAutoRed extends LinearOpMode {
    DirectionalDrive drive;
    RotationSensor rotationSensor;
    DistanceChecker distanceChecker;
    SideBlockGrabber sideBlockGrabber;
    double DISTANCEFROMBLOCK = 1;

    public void initializeHardware(){
        drive = new DirectionalDrive(this);
        rotationSensor = new RotationSensor(this);
        distanceChecker = new DistanceChecker(this);
        sideBlockGrabber = new SideBlockGrabber(this);
        telemetry.addLine("Initialized Hardware");
        telemetry.addLine("Don’t use “beef stew” as a computer password. It’s not stroganoff.");
        telemetry.update();
    }
    @Override
    public void runOpMode() {
        initializeHardware();
        telemetry.addLine("STARTING");
        waitForStart();
        while (distanceChecker.getINCHES()>DISTANCEFROMBLOCK && this.opModeIsActive()){
            telemetry.addLine("Going left");
            drive.goLeftV2(.75f);
            telemetry.update();

        }
        drive.stop();
        sleep(100);
        sideBlockGrabber.grab();
        sleep(2000);
        drive.goRightV2(1f);
        sleep(1000);
        telemetry.addLine("We about to go forward");
        telemetry.update();

        drive.goForwardV2(1);
        sleep(1500);
        drive.stop();



    }
}
