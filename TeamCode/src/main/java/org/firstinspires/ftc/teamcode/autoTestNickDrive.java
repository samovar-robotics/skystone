package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class autoTestNickDrive extends LinearOpMode {

    NickDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new NickDrive(this);

        drive.goForward();
        sleep(1000);
        drive.stop();
        sleep(200);
        drive.goBackward();
        sleep(200);
        drive.goLeft();
        sleep(1000);
        drive.stop();
        sleep(200);
        drive.goRight();
        sleep(1000);
        drive.stop();
    }
}
