package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "> Driver Controlled", group = "competition")
public class DriverControlledOpMode extends OpMode {
    private Drive drive;
    private TrayGrabber trayGrabber;
    private TeamMarker teamMarker;
    private Intake intake;
    private Whiskers whiskers;

    @Override
    public void init() {
        drive = new Drive(this);
        trayGrabber = new TrayGrabber(this);
        teamMarker = new TeamMarker(this);
        intake = new Intake(this);
        whiskers = new Whiskers(this);
    }

    @Override
    public void loop() {
        drive.DriveOmni(gamepad1);
        teamMarker.drop(gamepad1.right_trigger);
        trayGrabber.operate(gamepad2.left_bumper);
        intake.operate(gamepad2);
        whiskers.operate(gamepad1);
    }

    @Override
    public void stop(){
        drive.stop();
        intake.stop();
    }
}

