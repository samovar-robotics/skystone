package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DistanceChecker {
    DistanceSensor distanceSensor;
    HardwareMap hardwareMap;
    Telemetry telemetry;

    DistanceChecker(OpMode opMode){
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;
        this.distanceSensor = hardwareMap.get(DistanceSensor.class ,"sideDistanceSensor");
    }

    double getCM(){
        return distanceSensor.getDistance(DistanceUnit.CM);
    }
}
