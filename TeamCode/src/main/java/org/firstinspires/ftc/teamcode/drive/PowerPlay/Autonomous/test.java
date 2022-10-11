package org.firstinspires.ftc.teamcode.drive.PowerPlay.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "test", group = "Concept")
public class test extends LinearOpMode {

    private DcMotorEx leftFront;
    private DcMotorEx leftRear;
    private DcMotorEx rightRear;
    private DcMotorEx rightFront;
    @Override
    public void runOpMode() throws InterruptedException {

        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        leftRear = hardwareMap.get(DcMotorEx.class, "leftRear");
        rightRear = hardwareMap.get(DcMotorEx.class, "rightRear");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");


        while ((!isStarted() && !isStopRequested())){

        }

//        TrajectorySequence test2 = drive.trajectorySequenceBuilder(startPose2)
//                .lineToSplineHeading(new Pose2d(50, 0, Math.toRadians(0)))
//                .splineTo(new Vector2d(60, 5), Math.toRadians(45))
//                .addTemporalMarker(1.2 + x, () -> {
//                    armVert.setTargetPosition(-800);//-750
//                    armPivot.setTargetPosition(390);
//                    intakeMaster.setPosition(0.35);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                    turretDrive.setTargetPosition(-630);
//                })
//
//                .addTemporalMarker(3.7 + x, () -> {
//                    intakeMaster.setPosition(0.34);
//                    turretDrive.setTargetPosition(-630);
//                    armPivot.setTargetPosition(1900);
//                    armVert.setTargetPosition(-2000);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                })
//
//                .waitSeconds(1)
//                .setReversed(true)
//                .splineToSplineHeading(new Pose2d(50, 0, Math.toRadians(0)), Math.toRadians(180))
//                .splineToSplineHeading(new Pose2d(11.5, 0, Math.toRadians(0)), Math.toRadians(180))
//
//                .addTemporalMarker(4 + x, () -> {
//                    intakeMaster.setPosition(0.37);
//                    armPivot.setTargetPosition(2550);
//                    armVert.setTargetPosition(-90);
//                    turretDrive.setTargetPosition(-2325);
//                })
//                .addTemporalMarker(5.2 + x,() -> {
//                    intakeMaster.setPosition(0.39);
//                    intakeMotor.setPower(0.35);
//                    intakeTilt.setPosition(0.2);
//                })
//
//                .addTemporalMarker(6 + x, () -> {
//                    intakeMaster.setPosition(0.34);
//                    turretDrive.setTargetPosition(-630);
//                    armPivot.setTargetPosition(1900);
//                    armVert.setTargetPosition(-2000);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                    x = 0.5;
//                })
//                .waitSeconds(0.5)
//
//                //Second Cycle
//                .lineToSplineHeading(new Pose2d(50, 5, Math.toRadians(0)))
//                .splineTo(new Vector2d(65, 10), Math.toRadians(45))
//
//                .addTemporalMarker(7 + x, () -> {
//                    armVert.setTargetPosition(-800);//-750
//                    armPivot.setTargetPosition(390);
//                    intakeMaster.setPosition(0.35);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                    turretDrive.setTargetPosition(-630);
//                })
//                .addTemporalMarker(10 + x, () -> {
//                    intakeMaster.setPosition(0.34);
//                    turretDrive.setTargetPosition(-630);
//                    armPivot.setTargetPosition(1900);
//                    armVert.setTargetPosition(-2000);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                })
//
//
//                .waitSeconds(1)
//                .splineToSplineHeading(new Pose2d(50, 5, Math.toRadians(0)), Math.toRadians(180))
//                .splineToSplineHeading(new Pose2d(11.5, 5, Math.toRadians(0)), Math.toRadians(180))
//
//                .addTemporalMarker(10.5 + x, () -> {
//                    intakeMaster.setPosition(0.37);
//                    armPivot.setTargetPosition(2550);
//                    armVert.setTargetPosition(-90);
//                    turretDrive.setTargetPosition(-2375);
//                })
//                .addTemporalMarker(11.75 + x,() -> {
//                    intakeMaster.setPosition(0.39);
//                    intakeMotor.setPower(0.3);
//                    intakeTilt.setPosition(0.2);
//                })
//                .addTemporalMarker(12.2 + x, () -> {
//                    intakeMaster.setPosition(0.34);
//                    turretDrive.setTargetPosition(-630);
//                    armPivot.setTargetPosition(1900);
//                    armVert.setTargetPosition(-2000);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                    x = 0.75;
//                })
//
//
//                //Third Cycle
//                .waitSeconds(1)
//                .lineToSplineHeading(new Pose2d(50, 7, Math.toRadians(0)))
//                .splineTo(new Vector2d(63, 12), Math.toRadians(60))
//
//                .addTemporalMarker(13.5 + x, () -> {
//                    armVert.setTargetPosition(-800);//-750
//                    armPivot.setTargetPosition(390);
//                    intakeMaster.setPosition(0.35);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                    turretDrive.setTargetPosition(-630);
//                })
//                .addTemporalMarker(16 + x, () -> {
//                    intakeMaster.setPosition(0.34);
//                    turretDrive.setTargetPosition(-630);
//                    armPivot.setTargetPosition(1900);
//                    armVert.setTargetPosition(-2000);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                })
//
//
//                .waitSeconds(1)
//                .splineToSplineHeading(new Pose2d(50, 5, Math.toRadians(-10)), Math.toRadians(180))
//                .splineToSplineHeading(new Pose2d(10, 5, Math.toRadians(-10)), Math.toRadians(180))
//
//                .addTemporalMarker(17 + x, () -> {
//                    intakeMaster.setPosition(0.37);
//                    armPivot.setTargetPosition(2550);
//                    armVert.setTargetPosition(-90);
//                    turretDrive.setTargetPosition(-2400);
//                })
//                .addTemporalMarker(18.4 + x,() -> {
//                    intakeMaster.setPosition(0.39);
//                    intakeMotor.setPower(0.3);
//                    intakeTilt.setPosition(0.2);
//                })
//                .addTemporalMarker(19 + x, () -> {
//                    intakeMaster.setPosition(0.34);
//                    turretDrive.setTargetPosition(-630);
//                    armPivot.setTargetPosition(1900);
//                    armVert.setTargetPosition(-2000);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                })
//                .addTemporalMarker(25, () -> {
//                    intakeMaster.setPosition(0.34);
//                    turretDrive.setTargetPosition(-630);
//                    armPivot.setTargetPosition(1900);
//                    armVert.setTargetPosition(-2000);
//                    intakeTilt.setPosition(0.1);
//                    intakeMotor.setPower(-1);
//                })
//                .waitSeconds(0.5)
//                .lineToSplineHeading(new Pose2d(52, 7, Math.toRadians(-10)))
//                .splineTo(new Vector2d(60, 20), Math.toRadians(0))

        waitForStart();
        if (isStopRequested()) return;

        leftFront.setPower(1);
        sleep(2000);
        leftRear.setPower(1);
        sleep(2000);
        rightRear.setPower(1);
        sleep(2000);
        rightFront.setPower(1);
        sleep(2000);

    }
}
