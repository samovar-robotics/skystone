package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DistanceChecker {
    HardwareMap hardwareMap;
    Telemetry telemetry;

    DistanceSensor sensor;
    Rev2mDistanceSensor sensorConfigured;
    DistanceChecker(OpMode opMode){
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;
        sensor = (hardwareMap.get(DistanceSensor.class, "sideDistanceSensor"));
        sensorConfigured = (Rev2mDistanceSensor)sensor;

    }
    public double getINCHES(){
        telemetry.addData("Distance in Inches", sensor.getDistance(DistanceUnit.INCH));
        return sensorConfigured.getDistance(DistanceUnit.INCH);

    }

    public double getCM(){
        return sensorConfigured.getDistance(DistanceUnit.CM);
    }

}
