package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//@TeleOp(name = "Test Side Grabber", group = "tests")
public class TestSideGrabber extends OpMode {

    private SideBlockGrabber sideBlockGrabber;

    @Override
    public void init() {
        sideBlockGrabber = new SideBlockGrabber(this);
    }

    @Override
    public void loop() {
        sideBlockGrabber.operate(gamepad2);
        telemetry.addData("DATA",sideBlockGrabber.currentPosition());
    }
}
