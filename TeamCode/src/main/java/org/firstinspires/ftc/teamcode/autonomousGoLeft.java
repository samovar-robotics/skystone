package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



@Autonomous(name = "Autonomous Left", group = "Competition")
public class autonomousGoLeft extends LinearOpMode {
    Drive drive = null;


    public void initializeHardware() {
        drive = new Drive(this);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        initializeHardware();
        waitForStart();
        drive.Crab(-1);
        sleep(750);
        drive.stop();
    }
}
