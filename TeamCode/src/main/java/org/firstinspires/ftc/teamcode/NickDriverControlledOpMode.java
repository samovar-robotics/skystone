package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@TeleOp(name = "Nick Driver Controlled", group = "tests")
public class NickDriverControlledOpMode extends OpMode {
    private NickDrivetrain driveClass;
    private TrayGrabber trayGrabber;
    private TeamMarker teamMarker;
    private Intake intake;
    private Whiskers whiskers;

    @Override
    public void init() {
        driveClass = new NickDrivetrain(this);
        trayGrabber = new TrayGrabber(this);
        teamMarker = new TeamMarker(this);
        intake = new Intake(this);
        whiskers = new Whiskers(this);
    }

    @Override
    public void loop() {
        driveClass.drive(gamepad1);
        teamMarker.drop(gamepad1.right_trigger);
        trayGrabber.operate(gamepad2.left_bumper);
        intake.operate(gamepad2);
        whiskers.operate(gamepad2);
    }

    @Override
    public void stop() {
        driveClass.stop();
        intake.stop();
    }
}
