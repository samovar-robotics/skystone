package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="ALR IDK WHAT  THIS IS GONNA DO BUT LETS DO ITTTTT", group = "tests")
public class TestingOpmode extends LinearOpMode {
    public static final float POWER = 0.8f;
    Drive drive;
    public void initializeHardware(){
        drive = new Drive(this);

        telemetry.addLine("Initialized Hardware");
        telemetry.addLine("Don’t use “beef stew” as a computer password. It’s not stroganoff.");
        telemetry.update();
    }
    @Override
    public void runOpMode() {
        initializeHardware();
        waitForStart();
        //LEFT
        drive.autonomousCorrectedDrive(POWER, 0);
        sleep(1000);
        drive.stop();
        //BACK
        drive.autonomousCorrectedDrive(0, POWER);
        sleep(1000);
        drive.stop();
        //RIGHT
        drive.autonomousCorrectedDrive(-POWER, 0);
        sleep(1000);
        drive.stop();
        //FORWARD
        drive.autonomousCorrectedDrive(0, -POWER);
        sleep(1000);
        drive.stop();
        sleep(400);

    }

    private boolean withinTimeBox(double seconds) {
        if (getRuntime() > seconds) {
            telemetry.addData("Time-box elapsed seconds.", seconds);
            return false;
        }
        return opModeIsActive();
    }

}
