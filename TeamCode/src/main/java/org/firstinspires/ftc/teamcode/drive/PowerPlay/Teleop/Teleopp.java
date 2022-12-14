package org.firstinspires.ftc.teamcode.drive.PowerPlay.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Teleopp", group="Iterative Opmode")
public class Teleopp extends OpMode {

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
    private int elevatorTarget = 0;

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

        dbv4b.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dbv4b.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dbv4b.setTargetPosition(0);
        dbv4b.setPower(1);

        elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevator.setTargetPosition(0);
        elevator.setPower(1);
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


        //Slowmode
        if(gamepad1.dpad_up){
            Turnmultiplier = 1;
            multiplier = 1;
            Strafemultiplier = 1;
        }
        if(gamepad1.dpad_right){
            Turnmultiplier = 0.70;
            Strafemultiplier = 0.5;
            multiplier = 1;
        }

        //Super slow
        if(gamepad1.dpad_down){
            Turnmultiplier = 0.4;
            multiplier = 0.5;
            Strafemultiplier = 0.5;
        }
        if(gamepad1.dpad_left){
            Turnmultiplier = 0.5;
            multiplier = 0.6;
            Strafemultiplier = 0.5;
        }

        //Adjustment for 4 bar
        dbv4bTarget += gamepad2.right_stick_y * -50;
        elevatorTarget += gamepad2.left_stick_y * -50;

        //Down
        if(gamepad2.a){
            dbv4bTarget = 0;
            elevatorTarget = 0;
        }
        //Up
        if(gamepad2.y){
            dbv4bTarget = 0;
            elevatorTarget = 0;
        }
        //Close
        if(gamepad2.x){
            claw1.setPosition(0);
            claw2.setPosition(0);
        }
        //Open
        if(gamepad2.b){
            claw1.setPosition(0);
            claw2.setPosition(0);
        }


//        if (gamepad2.back) {
//            if ((mode1) && (holdTimerA.time() > 0.5)) {
//
//                telemetry.addLine("among");
//                mode2 = true;
//                mode1 = false;
//                holdTimerA.reset();
//            } else if ((mode2) && (holdTimerA.time() > 0.5)) {
//                telemetry.addLine("us");
//                mode1 = true;
//                mode2 = false;
//                holdTimerA.reset();
//            }
//        }

        dbv4b.setTargetPosition(dbv4bTarget);

        telemetry.addData("dbv4b ???", dbv4b.getCurrentPosition());
        telemetry.addData("elevator ???", elevator.getCurrentPosition());


        telemetry.update();
    }


}
