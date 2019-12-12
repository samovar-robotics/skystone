package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Autonomous Grab ", group = "Competition")
public class AutoGrabFoundation extends LinearOpMode {
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
        sleep(1200);
        drive.DriveTank(.6f,.6f);
        sleep(100);
        trayGrabber.grab();
        sleep(400);
        drive.DriveTank(-.75f,-.75f);
        sleep(1700);
        drive.stop();
        sleep(100);
        trayGrabber.letGo();

    }
}
