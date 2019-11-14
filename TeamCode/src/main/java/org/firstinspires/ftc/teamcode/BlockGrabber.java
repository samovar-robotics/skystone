package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//OUTDATED
//USED AT COMPETITION 0
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

    public void stop() {
        leftServo.setPower(0);
        rightServo.setPower(0);
    }
    public void runServos(double power){
        leftServo.setPower(power);
        rightServo.setPower(power);
    }

    public void operate(Gamepad g) {
        if (g.left_trigger > 0.1) {
            runServos(g.left_trigger);

            telemetry.addLine("Grab block");
        } else if (g.right_trigger > 0.1) {
            runServos(-g.right_trigger);
            telemetry.addLine("Release block");
        } else {
            stop();

        }
    }
}
