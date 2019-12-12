package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class SideDistanceSensor {
    DistanceSensor distanceSensor;
    SideDistanceSensor(DistanceSensor distanceSensor){
        this.distanceSensor = distanceSensor;
    }
    double getCM(){
        return distanceSensor.getDistance(DistanceUnit.CM);
    }
}
