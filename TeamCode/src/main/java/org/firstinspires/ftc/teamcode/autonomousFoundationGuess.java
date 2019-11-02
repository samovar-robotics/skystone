package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Autonomous grab foundation", group = "Competition")
public class autonomousFoundationGuess extends LinearOpMode {
    Drive drive = null;

    private TrayGrabber trayGrabber = null;

    public void initializeHardware() {
        drive = new Drive(this);
        trayGrabber = new TrayGrabber(this);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initializeHardware();
        waitForStart();
        drive.DriveTank(1,1);
        sleep(1500);
        drive.stop();
        sleep(100);
        trayGrabber.grab();
        sleep(100);
        drive.DriveTank(-1,-1);
        sleep(1000);
        drive.stop();
        sleep(100);
        trayGrabber.letGo();

    }
}
