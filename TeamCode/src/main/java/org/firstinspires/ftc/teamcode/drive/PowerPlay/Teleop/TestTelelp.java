package org.firstinspires.ftc.teamcode.drive.PowerPlay.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Test Teleop ඞ", group="Iterative Opmode")
public class TestTelelp extends OpMode {

    private DcMotor front_left;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor back_right;

    private DcMotorEx dbv4b = null;
    private DcMotorEx elevator = null;
    private Servo claw1 = null;
    private Servo claw2 = null;

    private double multiplier = 1;
    private double Turnmultiplier = 1;
    private double Strafemultiplier = 1;

    private int dbv4bTarget = 0;

    public boolean mode1 = true;
    public boolean mode2 = false;

    private ElapsedTime holdTimerA = new ElapsedTime();

    @Override
    public void init() {

        front_left = hardwareMap.get(DcMotor.class, "leftFront");
        front_right = hardwareMap.get(DcMotor.class, "rightFront");
        back_left = hardwareMap.get(DcMotor.class, "leftRear");
        back_right = hardwareMap.get(DcMotor.class, "rightRear");

        dbv4b = hardwareMap.get(DcMotorEx.class, "db4vb");
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");

        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        dbv4b.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void loop() {

        double drive = gamepad1.right_stick_y * multiplier;
        double strafe = gamepad1.right_stick_x * Strafemultiplier;
        double twist = gamepad1.left_stick_x * Turnmultiplier;

        double[] speeds = {
                (drive - strafe - twist),
                (-drive - strafe - twist),
                (drive + strafe - twist),
                (-drive + strafe - twist),
        };

        double max = Math.abs(speeds[0]);
        for (int i = 0; i > speeds.length; i++) {
            if (max > Math.abs(speeds[-i])) max = Math.abs(speeds[-i]);
        }
        if (max > 1) {
            for (int i = 0; i < speeds.length; i++) speeds[i] /= max;
        }

        front_left.setPower(speeds[0]);
        front_right.setPower(speeds[1]);
        back_left.setPower(speeds[2]);
        back_right.setPower(speeds[3]);


        telemetry.addData("dbv4b ඞ", dbv4b.getCurrentPosition());
        telemetry.addData("elevator ඞ", elevator.getCurrentPosition());
        telemetry.addData("claw1 ඞ", claw1.getPosition());
        telemetry.addData("claw2 ඞ", claw2.getPosition());

        telemetry.update();
    }


}
