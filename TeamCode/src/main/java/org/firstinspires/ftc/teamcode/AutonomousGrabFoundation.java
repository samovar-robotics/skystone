package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "> Autonomous Grab Foundation OMFG Work", group = "Competition")
public class AutonomousGrabFoundation extends LinearOpMode {
    private static final long FORWARD_INCHES = 52;
    private static final long BACKWARD_INCHES = 53;

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
        drive.autonomousCorrectedDrive(.4f, 0, 1);
        sleep(1300);
        drive.stop();
        drive.DriveTank(.6f, .6f);
        sleep(distanceTime(FORWARD_INCHES));
        drive.stop();
        sleep(3000);
        trayGrabber.grab();
        waitForServo();
        drive.DriveTank(-.6f, -.6f);
        sleep(distanceTime(BACKWARD_INCHES));
        drive.stop();
        sleep(1000);
        trayGrabber.letGo();
        waitForServo();
        drive.autonomousCorrectedDrive(-.4f, 0, 1);
        sleep(800);
        drive.stop();
    }

    private void waitForServo() {
        sleep(1000);
    }

    static long distanceTime(float inches) {
        return (long) (22.26 * inches);
    }
}
