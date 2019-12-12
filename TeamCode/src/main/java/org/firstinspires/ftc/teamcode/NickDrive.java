package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class NickDrive {

    private HardwareMap hardwareMap;
    private DcMotor leftBack, rightBack, leftFront, rightFront;
    NickDrive(OpMode opMode){
        hardwareMap = opMode.hardwareMap;

        this.leftBack = hardwareMap.dcMotor.get("leftBack");
        this.rightBack = hardwareMap.dcMotor.get("rightBack");
        this.leftFront = hardwareMap.dcMotor.get("leftFront");
        this.rightFront = hardwareMap.dcMotor.get("rightFront");

        this.leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        this.leftFront.setDirection(DcMotorSimple.Direction.FORWARD);

        this.rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rightFront.setDirection(DcMotorSimple.Direction.REVERSE);

        this.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    void moveController(float x, float y) {
        rightBack.setPower((x-y)/2);
        rightFront.setPower((x+y)/2);
        leftFront.setPower((x-y)/2);
        leftBack.setPower((x+y)/2);
    }

    void stop(){
        rightBack.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        leftFront.setPower(0);
    }

    void goForward(){
        moveController(0, 1);
    }
    void goBackward(){
        moveController(0, -1);
    }
    void goLeft(){
        moveController(-1, 0);
    }
    void goRight() {
        moveController(1, 0);
    }
}
