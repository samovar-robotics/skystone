package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Nick test directional drive", group = "tests")
public class autoTestNickDrive extends LinearOpMode {

    DirectionalDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new DirectionalDrive(this);

        drive.goForward(1);
        sleep(1000);
        drive.stop();
        sleep(200);
        drive.goBackward(1);
        sleep(1000);
        drive.stop();
        sleep(200);
        drive.goLeft(1);
        sleep(1000);
        drive.stop();
        sleep(200);
        drive.goRight(1);
        sleep(1000);
        drive.stop();
    }
}
