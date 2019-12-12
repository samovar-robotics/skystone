package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


//WHEN STARTING THIS, BE ON RED SIDE, FACING 90 DEGREES TOWARDS THE TAPE
@Autonomous(name = "Grab Block Red", group = "test")
public class grabBlockAutonomous extends LinearOpMode {

    Drive drive;
    BumpSensors bumpSensors;
    SideBlockGrabber sideBlockGrabber;
    RotationSensor rotationSensor;

    double rotationOrigin;
    double currentRotation;

    double ANGLETOLERANCE = 10;

    public void initializeHardware(){
        drive = new Drive(this);
        bumpSensors = new BumpSensors(this);
        sideBlockGrabber = new SideBlockGrabber(this);
        rotationSensor = new RotationSensor(this);
        telemetry.addLine("Hardware Initialized!");

    }

    @Override
    public void runOpMode() throws InterruptedException {
        initializeHardware();
        rotationOrigin = rotationSensor.getTurningDegrees();
        waitForStart();
        drive.Crab(-1);
        sleep(1250);
        currentRotation = rotationSensor.getTurningDegrees();
        if(Math.abs(currentRotation-rotationOrigin)<ANGLETOLERANCE){
            grabBlock();
        }else{
            adjustSelf(currentRotation-rotationOrigin);
        }


    }

    public void adjustSelf(double rotation){
        if(rotation<0){
            while(rotationSensor.getTurningDegrees()<10){
                drive.DriveTank(.5f, -.5f);
            }
        }else{
            while(rotationSensor.getTurningDegrees()>10){
                drive.DriveTank(-.5f, .5f);
            }

        }
        grabBlock();
    }

    public void grabBlock(){
        while (!bumpSensors.isSideTouched()){
            drive.Crab(-1);
        }
        drive.Crab(.1f);
        sideBlockGrabber.grab();
        sleep(500);
        drive.Crab(-1);
        sleep(750);
        drive.DriveTank(1,1);
        sleep(2000);
        drive.stop();
        sideBlockGrabber.goUp();
        sleep(500);
        drive.DriveTank(-1,-1);
        sleep(600);
        drive.stop();

    }
}
