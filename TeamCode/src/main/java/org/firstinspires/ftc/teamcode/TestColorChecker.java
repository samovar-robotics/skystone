package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test Color Checker", group = "tests")
public class TestColorChecker extends OpMode {
    CheckColor checkColor = null;
    @Override
    public void init() {
        checkColor = new CheckColor(this);
    }

    @Override
    public void loop() {
        checkColor.sayValues();
    }
}
