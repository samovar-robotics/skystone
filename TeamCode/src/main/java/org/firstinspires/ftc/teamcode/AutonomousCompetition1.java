package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class AutonomousCompetition1 extends LinearOpMode {
    Drive drive;
    SideSensor sideSensor;
    SideArm sideArm;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new Drive(this);
        sideSensor = new SideSensor(this);
        sideArm = new SideArm(this);
        waitForStart();
        while (!sideSensor.isTouched()){
            drive.Crab(.5);
        }
        drive.stop();
        sideArm.goDown();
        sleep(250);
        drive.Crab(-.25);
        sleep(500);
        drive.stop();
        sleep(100);
        drive.DriveTank(1,1);
        sleep(900);
        drive.stop();
        sleep(100);
        sideArm.goUp();
        sleep(500);
        drive.DriveTank(-1,-1);
        sleep(400);
        drive.stop();

    }
}
