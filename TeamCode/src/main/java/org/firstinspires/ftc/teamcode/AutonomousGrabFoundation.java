package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Move Foundation Comp 1", group ="Competition")
public class AutonomousGrabFoundation extends LinearOpMode {
    Drive drive;
    TrayGrabber trayGrabber;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(this);
        trayGrabber = new TrayGrabber(this);
        waitForStart();
        drive.DriveTank(.5f,.5f);
        sleep(3000);
        drive.stop();
        sleep(200);
        trayGrabber.grab();
        sleep(3000);
        drive.DriveTank(-.6f, -.6f);
        sleep(6000);
        drive.stop();
        trayGrabber.letGo();
        sleep(1000);
    }
}
