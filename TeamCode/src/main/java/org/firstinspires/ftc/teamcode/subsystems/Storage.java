package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Storage implements Mechanism {

    public Storage(){}
    public final NextCRServo intakeRoller = new NextCRServo(RobotController.controlHub(), 0);
    public final NextCRServo leftStorageRoller = new NextCRServo(RobotController.controlHub(), 1);
    public final NextCRServo rightStorageRoller = new NextCRServo(RobotController.controlHub(), 2);


    public void init(){
        intakeRoller.enable();
        leftStorageRoller.enable();
        rightStorageRoller.enable();
        intakeRoller.setDirection(NextMotor.Direction.REVERSE);
        leftStorageRoller.setDirection(NextMotor.Direction.FORWARD);
        rightStorageRoller.setDirection(NextMotor.Direction.FORWARD);
    }

    public Command spinStorage(){
        return Command.build().requiring(this).setStart(() -> {
            intakeRoller.setPower(1);
            leftStorageRoller.setPower(1);
            rightStorageRoller.setPower(1);
        });
    }

}
