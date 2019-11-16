package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Get Block Go Left", group = "Competition")
public class AutonomousCompetition1BlockGrabL extends LinearOpMode {
    Drive drive;
    Intake intake;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(this);
        intake = new Intake(this);
        waitForStart();
        drive.DriveTank(1,1);
        intake.setPower(1);
        sleep(1000);
        drive.stop();
        intake.stop();
        drive.DriveTank(-1,-1);
        sleep(750);
        drive.stop();
        sleep(100);
        drive.Crab(-1);
        sleep(800);
        drive.stop();
        sleep(100);
        intake.setPower(1);
        sleep(600);
        intake.stop();
    }
}
