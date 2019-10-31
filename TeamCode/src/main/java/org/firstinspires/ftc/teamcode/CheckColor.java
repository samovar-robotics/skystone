package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class CheckColor {
    private final Telemetry telemetry;
    private final HardwareMap hardwareMap;
    private ColorSensor colorSensor;

    public CheckColor(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;
        init();
    }

    public void init(){
        colorSensor = hardwareMap.get(ColorSensor.class,"colorSensor");

    }

    public void sayValues(){
        telemetry.addData("Red", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue", colorSensor.blue());

    }

    public boolean isRed(){
        int redAmount = colorSensor.red();
        if(redAmount>=200){
            return true;
        }else{
            return false;
        }
    }

}
