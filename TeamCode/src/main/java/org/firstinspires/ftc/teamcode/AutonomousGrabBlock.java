package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class AutonomousGrabBlock extends LinearOpMode {
    Drive drive = null;
    private TouchSensor frontTouch = null;
    private TouchSensor backTouch = null;
    private CheckColor checkColor = null;

    private TrayGrabber trayGrabber = null;

    private BlockGrabber blockGrabber;

    @Override
    public void runOpMode() {
        drive = new Drive(this);
        blockGrabber = new BlockGrabber(this);

        frontTouch = hardwareMap.touchSensor.get("frontTouch");
        backTouch = hardwareMap.touchSensor.get("backTouch");

        checkColor = new CheckColor(this);

        initializeHardware();
        telemetry.addLine("Hardware initialize");

        while(!frontTouch.isPressed()){
            drive.DriveTank(0.5f, 0.5f);
            blockGrabber.runServos(1);
        }
        drive.stop();
        blockGrabber.runServos(0);
        while (!backTouch.isPressed()){
            drive.DriveTank(0.5f, 0.5f);
        }

        drive.stop();
        while (true){

        }
        //drive.Crab(-1);

    }

    public void initializeHardware() {
        drive = new Drive(this);
        frontTouch = hardwareMap.touchSensor.get("frontTouch");
        backTouch = hardwareMap.touchSensor.get("backTouch");
        trayGrabber = new TrayGrabber(this);
    }
}
