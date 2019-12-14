package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name = "> Autonomous Go Right", group = "Competition")
public class AutonomousGoRight extends LinearOpMode {
    Drive drive = null;


    public void initializeHardware() {
        drive = new Drive(this);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        initializeHardware();
        waitForStart();
        drive.Crab(1);
        sleep(750);
        drive.stop();
    }
}
