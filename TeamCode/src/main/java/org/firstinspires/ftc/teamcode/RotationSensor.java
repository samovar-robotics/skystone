package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.util.Locale;

public class RotationSensor {
    private Telemetry telemetry;
    private  HardwareMap hardwareMap;
    public BNO055IMU imu;
    private float floorAngle1;
    private float floorAngle2;
    private double TILT_LIMIT = 1.5;

    public RotationSensor(OpMode opMode) {
        hardwareMap = opMode.hardwareMap;
        telemetry = opMode.telemetry;
        init();
    }
    public void init() {
        imu = initializeIMU();
    }
    private BNO055IMU initializeIMU() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        return imu;
    }
    public double getTurningDegrees() {
        Orientation orientation = getOrientation();
        double angleInDegrees = AngleUnit.DEGREES.fromUnit(orientation.angleUnit, orientation.firstAngle);
        telemetry.addData("Heading (degrees)", toString(angleInDegrees));
        return angleInDegrees;
    }

    public void calibrateTilt() {
        Orientation orientation = getOrientation();
        floorAngle1 = AngleUnit.DEGREES.fromUnit(orientation.angleUnit, orientation.secondAngle);
        floorAngle2 = AngleUnit.DEGREES.fromUnit(orientation.angleUnit, orientation.thirdAngle);

        telemetry.addData("Tilt angle 1", toString(floorAngle1));
        telemetry.addData("Tilt angle 2", toString(floorAngle2));
    }

    public boolean isTilted() {
        Orientation orientation = getOrientation();
        float angle1 = AngleUnit.DEGREES.fromUnit(orientation.angleUnit, orientation.secondAngle);
        float angle2 = AngleUnit.DEGREES.fromUnit(orientation.angleUnit, orientation.thirdAngle);

        float tilt1 = Math.abs(Math.abs(angle1) - Math.abs(floorAngle1));
        float tilt2 = Math.abs(Math.abs(angle2) - Math.abs(floorAngle2));

        telemetry.addData("Tilt angle 1", toString(floorAngle1));
        telemetry.addData("Tilt angle 2", toString(floorAngle2));

        return tilt1 > TILT_LIMIT || tilt2 > TILT_LIMIT;
    }

    private Orientation getOrientation() {
        return imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
    }

    public String toString(double degrees) {
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }


}
