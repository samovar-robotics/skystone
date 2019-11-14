package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Elevator {
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private DcMotor elevatorMotor;

    public Elevator(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;
        init();
    }


    public void init() {

        this.elevatorMotor = hardwareMap.dcMotor.get("elevatorMotor");

        this.elevatorMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        this.elevatorMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void stop() {
        elevatorMotor.setPower(0);
    }


    public void elevatorUp() {
        elevatorMotor.setPower(1);
    }
    public void elevatorDown() {
        elevatorMotor.setPower(-1);
    }
    public void controlElevator(Gamepad gamepad){
        if(gamepad.a){
            elevatorUp();
        }else if(gamepad.b){
            elevatorDown();
        }else{
            stop();
        }
    }






}
