package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorChecker {
    ColorSensor colorSensor;
    HardwareMap hardwareMap;
    Telemetry telemetry;
    ColorChecker(OpMode opMode){
        this.hardwareMap = opMode.hardwareMap;
        this.telemetry = opMode.telemetry;
        this.colorSensor = hardwareMap.colorSensor.get("colorSensor");

        init();
    };
    void init(){
        colorSensor.enableLed(true);
    }

    public void checkColor(){

    }

    public float[] formatColor(){
        float[] hsv = new float[3];

        return hsv;
    }

    void stop(){
        colorSensor.enableLed(false);
    }

    public enum colors{
        RED,
        BLUE,
        NOT,
    }
}
