package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive {
    private final Telemetry telemetry;
    private final HardwareMap hardwareMap;
    private DcMotor leftBack, rightBack, leftFront, rightFront;
    private double power;

    public Drive(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;
        init();
    }


    public void init() {
        this.leftBack = hardwareMap.dcMotor.get("leftBack");
        this.rightBack = hardwareMap.dcMotor.get("rightBack");
        this.leftFront = hardwareMap.dcMotor.get("leftFront");
        this.rightFront = hardwareMap.dcMotor.get("rightFront");

        this.leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        this.rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        this.leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rightFront.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void Stop() {
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void DriveOmni(Gamepad gamepad) {

        if (isCrabbing(gamepad)) {
            crab(gamepad.left_stick_x);
        } else {
            tank(gamepad.left_stick_y, gamepad.right_stick_y);
        }

        telemetry.addData("left back", leftBack.getPowerFloat());
        telemetry.addData("right back", rightBack.getPowerFloat());
        telemetry.addData("left front", leftFront.getPowerFloat());
        telemetry.addData("right front", rightFront.getPowerFloat());
    }

    private void tank(float leftPower, float rightPower) {
        leftFront.setPower(-leftPower);
        leftBack.setPower(-leftPower);

        rightFront.setPower(-rightPower);
        rightBack.setPower(-rightPower);
    }

    private void crab(float power) {
        leftBack.setPower(power);
        leftFront.setPower(-power);

        rightBack.setPower(-power);
        rightFront.setPower(-power);
    }

    private boolean isCrabbing(Gamepad g) {
        return Math.abs(g.left_stick_y) < 0.1 && Math.abs(g.right_stick_y) < 0.1 && Math.abs(g.left_stick_x) > 0.1;

    }
}
