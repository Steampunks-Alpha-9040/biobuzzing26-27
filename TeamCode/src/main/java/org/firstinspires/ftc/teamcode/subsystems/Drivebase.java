package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Drivebase implements Mechanism {
        public Drivebase(){}
        public final NextMotor frontLeft = new NextMotor(RobotController.controlHub(), 0);
        public final NextMotor frontRight = new NextMotor(RobotController.controlHub(), 1);
        public final NextMotor backLeft = new NextMotor(RobotController.controlHub(), 2);
        public final NextMotor backRight =  new NextMotor(RobotController.controlHub(), 3);

        public void init(){
                frontLeft.setDirection(NextMotor.Direction.FORWARD);
                frontRight.setDirection(NextMotor.Direction.REVERSE);
                backLeft.setDirection(NextMotor.Direction.FORWARD);
                backRight.setDirection(NextMotor.Direction.REVERSE);
                frontLeft.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
                frontRight.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
                backLeft.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
                backRight.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);

        }




}
