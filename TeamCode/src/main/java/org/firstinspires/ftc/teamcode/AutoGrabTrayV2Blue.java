package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "> Autonomous Grab Foundation Blue", group = "Competition")
public class AutoGrabTrayV2Blue extends LinearOpMode {
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
        drive.autonomousCorrectedDrive(.4f, 0, 1);
        sleep(1500);
        drive.stop();
        sleep(100);
        drive.autonomousCorrectedDrive(0, .5f, 1);
        sleep(1550);
        drive.stop();
        sleep(1000);
        drive.autonomousCorrectedDrive(0, .1f, 1);
        trayGrabber.grab();
        waitForServo();
        drive.stop();
        sleep(150);
        drive.autonomousCorrectedDrive(0, -.6f, 1);
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
