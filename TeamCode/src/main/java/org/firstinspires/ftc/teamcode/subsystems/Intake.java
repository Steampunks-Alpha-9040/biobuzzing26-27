package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;

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

    @NonNull
    public Command getDefaultCommand() {
        return stop();
    }

    public Command intake(){
        return Command.build().requiring(this).setStart(() -> {
            intakeServo1.setPower(1);
            intakeServo2.setPower(-1);
        });
    }

    public Command outtake(){
        return Command.build().requiring(this).setStart(() -> {
            intakeServo1.setPower(-1);
            intakeServo2.setPower(1);
        });
    }

    public Command stop(){
        return Command.build().requiring(this).setStart(() -> {
            intakeServo1.setPower(-1);
            intakeServo2.setPower(1);
        });
    }

}
