package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;


@Autonomous(name = "Move Foundation", group = "Competition")
public class AutonomousMoveFoundation extends LinearOpMode {

    Drive drive = null;
    private TouchSensor frontTouch = null;
    private TouchSensor backTouch = null;

    private TrayGrabber trayGrabber = null;

    private boolean touched = false;
    private boolean secondTouched = false;


    public void initializeHardware() {
        drive = new Drive(this);
        frontTouch = hardwareMap.touchSensor.get("frontTouch");
        backTouch = hardwareMap.touchSensor.get("backTouch");
        trayGrabber = new TrayGrabber(this);
    }

    @Override
    public void runOpMode()  {

        initializeHardware();
        telemetry.addLine("Hardware initialize");

        this.waitForStart();

        telemetry.clearAll();


        while (!backTouch.isPressed()) {
            telemetry.addLine("Driving to tray");
            drive.DriveTank(0.5f, 0.5f);
        }
        sleep(100);

        drive.stop();


        telemetry.addLine("Reached tray");
        this.sleep(2 * 1000);

        telemetry.addLine("Grabbing");
        trayGrabber.grab();
        this.sleep(2 * 1000);

        drive.DriveTank(-0.5f,-0.5f);
        this.sleep(3*1000);
        drive.stop();

        trayGrabber.letGo();
        telemetry.addLine("Done");
    }
}
