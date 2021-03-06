package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Rotation;

public class Drive {
    private final Telemetry telemetry;
    private final HardwareMap hardwareMap;
    private DcMotor leftBack, rightBack, leftFront, rightFront;
    private final float CORRECTION_BOOST = 0.15f;
    private RotationSensor rotationSensor;
    private double _heading;

    public Drive(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;

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
        this.rotationSensor = new RotationSensor(opMode);

    }

    public void stop() {
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
    }

    public void DriveOmni(Gamepad gamepad) {

        if (isCrabbing(gamepad)) {
            Crab(gamepad.left_stick_x);
        } else {
            DriveTank(gamepad.left_stick_y, gamepad.right_stick_y);
        }

        telemetry.addData("leftBack", leftBack.getPower());
        telemetry.addData("leftFront", leftFront.getPower());
        telemetry.addData("rightBack", rightBack.getPower());
        telemetry.addData("rightFront", rightFront.getPower());
    }

    public void DriveTank(float leftPower, float rightPower) {

        leftFront.setPower(leftPower);
        leftBack.setPower(leftPower);

        rightFront.setPower(rightPower);
        rightBack.setPower(rightPower);
    }

    public void Crab(float power) {
        //POSITIVE: RIGHT
        //NEGATIVE: LEFT
        float correctedPower = correct(power);
        telemetry.addData("Corrected Power", correctedPower);

        leftBack.setPower(-power);
        //MAYBE SWITCH +/-
        leftFront.setPower(+correctedPower);

        rightBack.setPower(power);
        rightFront.setPower(-correctedPower);
    }

    public void CrabBackwards(float power) {
        //POSITIVE: RIGHT
        //NEGATIVE: LEFT
        float correctedPower = correctBackward(power);
        telemetry.addData("Corrected Power", correctedPower);

        leftBack.setPower(-power);
        //MAYBE SWITCH +/-
        leftFront.setPower(+correctedPower);

        rightBack.setPower(power);
        rightFront.setPower(-correctedPower);
    }

    public void lockHeading() {
        this._heading = rotationSensor.getTurningDegrees();
    }

    private float correct(final float power) {
        double currentHeading = rotationSensor.getTurningDegrees();
        if (currentHeading > _heading + 1) {
            return power + CORRECTION_BOOST * power;
        }
        if (currentHeading < _heading - 1) {
            return power - CORRECTION_BOOST * power;
        }
        return power;
    }
    private float correctBackward(final float power) {
        double currentHeading = rotationSensor.getTurningDegrees();
        if (currentHeading > _heading + 1) {
            return power + CORRECTION_BOOST * power;
        }
        if (currentHeading < _heading - 1) {
            return power - CORRECTION_BOOST * power;
        }
        return power;
    }

    private boolean isCrabbing(Gamepad g) {
        return Math.abs(g.left_stick_y) < 0.1
                && Math.abs(g.right_stick_y) < 0.1
                && Math.abs(g.left_stick_x) > 0.1;

    }





    public void autonomousCorrectedDrive(float x, float y, float multiplier) {

        float turnRatio = .015f*multiplier;
        double currentHeading = rotationSensor.getTurningDegrees();
        float turnComponent = (float) (currentHeading)*turnRatio; //from -1 to 1

        rightBack.setPower((y - x) + turnComponent);
        rightFront.setPower((y + x) + turnComponent);
        leftFront.setPower((y - x) - turnComponent);
        leftBack.setPower((y + x) - turnComponent);
    }

    public void autonomousSelfCorrect(){
        float tolerance = 2;
        double currentHeading = rotationSensor.getTurningDegrees();
        if(Math.abs(currentHeading)>tolerance) {
            float turnRatio = .115f;
            float turnComponent = (float) (currentHeading) * turnRatio;

            rightBack.setPower(turnComponent);
            rightFront.setPower(turnComponent);
            leftFront.setPower(-turnComponent);
            leftBack.setPower(-turnComponent);
        }
    }

    public void omniDrive(Gamepad gamepad){ //not finished, needs a rotational tracker
        float x0 = gamepad.right_stick_x;
        float y0 = gamepad.right_stick_y;
        float x1 = gamepad.left_stick_x;
        float y1 = gamepad.left_stick_y;
        if(Math.abs(Math.abs(gamepad.right_stick_x) - Math.abs(gamepad.left_stick_x)) < .15) { //same x components
            if(Math.abs(Math.abs(gamepad.right_stick_x) - Math.abs(gamepad.left_stick_x)) < .15) { //same y components
                float x = (x0 + x1)/2; //averages values
                float y = (y0 + y1)/2;
            }
            if (Math.abs(gamepad.right_stick_x) + Math.abs(gamepad.left_stick_x) < .15) { //almost tank drive


            }
        }

        float turnRatio = (float) (.0001);
        double currentHeading = rotationSensor.getTurningDegrees();
        float turnComponent = (float) (currentHeading)*turnRatio; //from -1 to 1

        rightBack.setPower((x0-y0) + turnComponent);
        rightFront.setPower((x0+y0) + turnComponent);
        leftFront.setPower((x1-y1) - turnComponent);
        leftBack.setPower((x1+y1) - turnComponent);

    }



}
