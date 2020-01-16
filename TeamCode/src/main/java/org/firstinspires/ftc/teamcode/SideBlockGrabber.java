package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

class SideBlockGrabber {
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private final Servo upDownServo;
    private static final float UP = 0f;
    private static final float DOWN = .42f;
    private static final float CLAMP = 0f;
    private static final float RELEASE = .5f;
    private Servo clampServo;

    public SideBlockGrabber(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;

        upDownServo = hardwareMap.servo.get("upDownServo");
        clampServo = hardwareMap.servo.get("clampServo");

        telemetry.addData("up is", UP);
        telemetry.addData("down is", DOWN);
        telemetry.addData("clamp is", CLAMP);
        telemetry.addData("release is", RELEASE);

    }
    public double currentPosition(){
        return upDownServo.getPosition();
    }

    public void up() {
        telemetry.addData("SideBlockGrabber up", UP);
        upDownServo.setPosition(UP);
    }

    public void down() {
        telemetry.addData("SideBlockGrabber down", DOWN);
        upDownServo.setPosition(DOWN);
    }

    public void clamp() {
        telemetry.addData("SideBlockGrabber clamp", CLAMP);
        clampServo.setPosition(CLAMP);
    }

    public void release() {
        telemetry.addData("SideBlockGrabber release", RELEASE);
        clampServo.setPosition(RELEASE);
    }

    public void operate(Gamepad gamepad) {
        if (gamepad.y) {
            up();
        }
        if (gamepad.a) {
            down();
        }
        if (gamepad.x) {
            release();
        }
        if (gamepad.b) {
            clamp();
        }
    }
}
