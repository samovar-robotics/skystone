package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Driver Controlled", group = "competition")
public class DriverControlledOpMode extends OpMode {
    private Drive drive;
    private TrayGrabber trayGrabber;
    private BlockGrabber blockGrabber;
    private TeamMarker teamMarker;
    //private Elevator elevator;
    @Override
    public void init() {
        drive = new Drive(this);
        trayGrabber = new TrayGrabber(this);
        blockGrabber = new BlockGrabber(this);
        teamMarker = new TeamMarker(this);
        //elevator = new Elevator(this);
    }

    @Override
    public void loop() {
        drive.DriveOmni(gamepad1);
        trayGrabber.operate(gamepad2.left_bumper);
        blockGrabber.operate(gamepad2);
        //elevator.controlElevator(gamepad2);
        teamMarker.drop(gamepad1.right_trigger);
    }
}

