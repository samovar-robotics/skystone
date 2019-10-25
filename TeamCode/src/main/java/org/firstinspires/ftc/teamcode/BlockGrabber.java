package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BlockGrabber {
    CRServo leftServo;
    CRServo rightServo;
    private Telemetry telemetry;
    private HardwareMap hardwareMap;

    public BlockGrabber(OpMode opMode) {

        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;

        leftServo = hardwareMap.crservo.get("leftBlockServo");
        rightServo = hardwareMap.crservo.get("rightBlockServo");
        leftServo.setDirection(DcMotorSimple.Direction.FORWARD);
        rightServo.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    public void go(Gamepad g) {
        if (g.left_trigger > 0) {
            leftServo.setPower(g.left_trigger);
            rightServo.setPower(g.left_trigger);
            telemetry.addLine("Grab block");
        }
        if (g.right_trigger > 0) {
            leftServo.setPower(-g.right_trigger);
            rightServo.setPower(-g.right_trigger);
            telemetry.addLine("Release block");
        }
    }
}
