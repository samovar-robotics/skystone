package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "test gyro #2", group="tests")
public class GyroConcept extends OpMode {
    RotationSensor rotationSensor = null;



    @Override
    public void init() {
        telemetry.addLine("INITIALZEDD NOT PSYCHE");
        telemetry.addLine("Started");
        rotationSensor = new RotationSensor(this);
        telemetry.addLine("Started Init");
        rotationSensor.init();
        telemetry.addLine("Initialized");
    }

    @Override
    public void loop() {
        double angle =  rotationSensor.getTurningDegrees();
        telemetry.addData(
                "Angle", angle
        );

    }
}
