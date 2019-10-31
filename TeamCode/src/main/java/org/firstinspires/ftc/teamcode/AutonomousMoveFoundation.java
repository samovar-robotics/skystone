package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "Move Foundation", group = "Competition")
public class AutonomousMoveFoundation extends LinearOpMode {

    Drive drive = null;

    private TrayGrabber trayGrabber = null;

    private BumpSensors bumpSensors = null;

    public void initializeHardware() {
        drive = new Drive(this);
        trayGrabber = new TrayGrabber(this);
        bumpSensors = new BumpSensors(this);
    }

    @Override
    public void runOpMode() {

        initializeHardware();
        telemetry.addLine("Hardware initialize");

        this.waitForStart();

        telemetry.clearAll();


        while (!bumpSensors.isBackTouched()) {
            telemetry.addLine("Driving to tray");
            drive.DriveTank(0.5f, 0.5f);
        }
        drive.stop();

        telemetry.addLine("Reached tray");
        this.sleep(2 * 1000);

        telemetry.addLine("Grabbing");
        trayGrabber.grab();
        this.sleep(2 * 1000);

        while (!bumpSensors.isFrontTouched()) {
            drive.DriveTank(-0.5f, -0.5f);
        }
        drive.stop();

        this.sleep(2 * 1000);
        trayGrabber.letGo();
        telemetry.addLine("Done");
    }
}
