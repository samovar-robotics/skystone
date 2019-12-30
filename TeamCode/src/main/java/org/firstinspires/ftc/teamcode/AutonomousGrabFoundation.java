package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "> Autonomous Grab Foundation", group = "Competition")
public class AutonomousGrabFoundation extends LinearOpMode {
    private static final long FORWARD_INCHES = 52;
    private static final long BACKWARD_INCHES = 48;

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
        drive.DriveTank(1, 1);
        sleep(distanceTime(FORWARD_INCHES));
        drive.stop();
        sleep(1000);
        trayGrabber.grab();
        waitForServo();
        drive.DriveTank(-1, -1);
        sleep(distanceTime(BACKWARD_INCHES));
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
