package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class NickDrivetrain {
    private final Telemetry telemetry;
    private final HardwareMap hardwareMap;
    private DcMotor leftBack, rightBack, leftFront, rightFront;

    public NickDrivetrain(OpMode opMode) {
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
        this.leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        this.rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rightFront.setDirection(DcMotorSimple.Direction.REVERSE);

        this.leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void stop() {
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
    }

    public void drive(Gamepad gamepad) {
        float x0 = gamepad.right_stick_x;
        float y0 = gamepad.right_stick_y;
        float x1 = gamepad.left_stick_x;
        float y1 = gamepad.left_stick_y;
        rightBack.setPower(y0-x0);
        rightFront.setPower(y0+x0);
        leftFront.setPower(y1-x1);
        leftBack.setPower(y1+x1);
    }

    private float toMotorLimit(float f) {
        // f/=1.45;
        return Range.clip(f, -1, 1);
    }
}
