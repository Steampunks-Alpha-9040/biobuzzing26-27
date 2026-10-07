package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.drive.DriveCommands;

public class Drivebase implements Mechanism {
        public Drivebase(){}
        public final NextMotor frontLeft = new NextMotor(RobotController.controlHub(), 0);
        public final NextMotor frontRight = new NextMotor(RobotController.controlHub(), 1);
        public final NextMotor backLeft = new NextMotor(RobotController.controlHub(), 2);
        public final NextMotor backRight =  new NextMotor(RobotController.controlHub(), 3);

        public void init(){
                frontLeft.setDirection(NextMotor.Direction.REVERSE);
                frontRight.setDirection(NextMotor.Direction.FORWARD);
                backLeft.setDirection(NextMotor.Direction.REVERSE);
                backRight.setDirection(NextMotor.Direction.FORWARD);
                frontLeft.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
                frontRight.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
                backLeft.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
                backRight.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
        }

        public Command startDrive(Gamepad gamepad1) {
                return DriveCommands.mecanumDrive(
                        frontLeft,
                        frontRight,
                        backLeft,
                        backRight,
                        gamepad1
                );
        }
}
