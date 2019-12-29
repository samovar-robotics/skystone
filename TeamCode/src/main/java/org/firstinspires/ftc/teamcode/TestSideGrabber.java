package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test Side Grabber", group = "tests")
public class TestSideGrabber extends OpMode {

    private SideGrabber sideGrabber;

    @Override
    public void init() {
        sideGrabber = new SideGrabber(this);
    }

    @Override
    public void loop() {
        sideGrabber.operate(gamepad2);
    }
}
