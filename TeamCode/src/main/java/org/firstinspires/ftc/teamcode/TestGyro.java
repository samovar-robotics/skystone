package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test Gyro", group = "tests")
public class TestGyro extends OpMode {
    RotationSensor rotationSensor = null;


    @Override
    public void init() {
        telemetry.addLine("Started Init");
        rotationSensor = new RotationSensor(this);
        telemetry.addLine("Initialized");
    }

    @Override
    public void loop() {
        double angle = rotationSensor.getTurningDegrees();
        telemetry.addData("Angle", angle);
    }
}
