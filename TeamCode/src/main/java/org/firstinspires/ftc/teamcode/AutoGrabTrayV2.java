package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "> Autonomous Grab Foundation V2", group = "Competition")
public class AutoGrabTrayV2 extends LinearOpMode {
    private static final long FORWARD_INCHES = 52;
    private static final long BACKWARD_INCHES = 60;

    Drive drive = null;

    private TrayGrabber trayGrabber = null;

    public void initializeHardware() {
        drive = new Drive(this);
        trayGrabber = new TrayGrabber(this);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initializeHardware();
        drive.lockHeading();
        waitForStart();
        drive.Crab(-.5f);
        sleep(1000);
        drive.stop();
        sleep(100);
        drive.autonomousCorrectedDrive(0, .8f, 1);
        sleep(1500);
        drive.stop();
        sleep(1000);
        trayGrabber.grab();
        waitForServo();
        drive.autonomousCorrectedDrive(0, -1, 4);
        sleep(2000);
        drive.stop();
        sleep(1000);
        trayGrabber.letGo();
        waitForServo();

    }

    private void waitForServo() {
        sleep(1000);
    }

    static long distanceTime(float inches) {
        return (long) (22.26 * inches);
    }
}
