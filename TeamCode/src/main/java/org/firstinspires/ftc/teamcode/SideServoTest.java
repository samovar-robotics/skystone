package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TEST SIDE SERVO", group = "TEST")
public class SideServoTest extends OpMode {
    SideBlockGrabber sideBlockGrabber;

    @Override
    public void init() {
        sideBlockGrabber = new SideBlockGrabber(this);
    }

    @Override
    public void loop() {
        telemetry.addData("Current Position", sideBlockGrabber.currentPosition());
        if(this.gamepad1.x){
            telemetry.addLine("X IS PRESSED");
            sideBlockGrabber.goUp();
        }else if(this.gamepad1.y){
            telemetry.addLine("Y IS PRESSED");

            sideBlockGrabber.grab();
        }
    }
}
