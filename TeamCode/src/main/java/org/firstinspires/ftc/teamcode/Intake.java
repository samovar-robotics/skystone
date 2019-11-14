package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.text.DecimalFormat;

public class Intake {
    private final Telemetry telemetry;
    private final HardwareMap hardwareMap;
    private DcMotor leftIntake, rightIntake;

    public Intake(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;
        init();
    }

    public void init() {
        this.leftIntake = hardwareMap.dcMotor.get("leftIntake");
        this.rightIntake = hardwareMap.dcMotor.get("rightIntake");

        // motors mounted opposite each other so they counter-rotate naturally
        this.leftIntake.setDirection(DcMotorSimple.Direction.FORWARD);
        this.rightIntake.setDirection(DcMotorSimple.Direction.FORWARD);

        this.leftIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        this.rightIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void stop() {
        this.leftIntake.setPower(0);
        this.rightIntake.setPower(0);
    }

    public void setPower(double power) {
        telemetry.addData("Inteke power", power);
        this.leftIntake.setPower(power);
        this.rightIntake.setPower(power);

    }

    public void operate(Gamepad gamepad) {

        float forward = gamepad.left_trigger;
        float backward = gamepad.right_trigger;
        if (forward > 0) {
            setPower(forward);
        } else if (backward > 0) {
            //Backward is negative because the motors need to go backwards
            setPower(-backward);
        } else {
            stop();
        }
    }
}
