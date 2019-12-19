package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
public class FunctionAutonomousMovement extends LinearOpMode {
    private final Telemetry telemetry;
    private final HardwareMap hardwareMap;
    private DcMotor leftBack, rightBack, leftFront, rightFront;

    public FunctionAutonomousMovement(OpMode opMode){
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;
        init();
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initializeHardware();
        moveController(0, 1, 500); //positive x is right, positive y is forward, t is movement time
        sleep(200);

        initializeHardware();
        moveController(-1, 0, 500);
        sleep(200);

        initializeHardware();
        moveController(0, -1, 500);
        sleep(200);

        initializeHardware();
        moveController(1, 0, 500);
        sleep(200);

    }

    public void initializeHardware() {
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
    void stopDrive(){
        leftBack.setPower(0);
        rightBack.setPower(0);
        leftFront.setPower(0);
        rightFront.setPower(0);
    }

    void moveController(float x, float y, int t) { //x movement component, y movement component, time

        rightBack.setPower((x-y)/2);
        rightFront.setPower((x+y)/2);
        leftFront.setPower((x-y)/2);
        leftBack.setPower((x+y)/2);
        sleep(t);
        stopDrive();

    }


}
