package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.behaviors.EndCondition;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {
    public Intake() {}
    public final NextCRServo intakeServo1 = new NextCRServo(RobotController.expansionHub(),0);
    public final NextCRServo intakeServo2 = new NextCRServo(RobotController.controlHub(),5);

    public void init(){
        intakeServo1.setDirection(NextMotor.Direction.FORWARD);
        intakeServo2.setDirection(NextMotor.Direction.FORWARD);
        intakeServo1.enable();
        intakeServo2.enable();
    }

    public Command intake(){
        return Command.build().setStart(() -> {
            intakeServo1.setPower(1);
            intakeServo2.setPower(-1);
        }).setEnd(endCondition -> {
            intakeServo1.setPower(0);
            intakeServo2.setPower(0);
        }).requiring(this);
    }

    public Command outtake(){
        return Command.build().setStart(() -> {
            intakeServo1.setPower(-1);
            intakeServo2.setPower(1);
        }).setEnd(endCondition -> {
            intakeServo1.setPower(0);
            intakeServo2.setPower(0);
        }).requiring(this);
    }


}
