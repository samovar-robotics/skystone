package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TeamMarker {
    private final Telemetry telemetry;
    private final Servo markerServo;

    public TeamMarker(OpMode opMode) {
        telemetry = opMode.telemetry;
        markerServo = opMode.hardwareMap.servo.get("teamMarkerServo");
        markerServo.setPosition(0);
    }

    public void drop(double targetPosition) {
        telemetry.addLine("Dropping marker");
        markerServo.setPosition(targetPosition);
    }
}
