package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.RobotConstants;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextFeedbackCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {

    public Intake(){}
    public final NextCRServo left_servo = new NextCRServo(RobotController.controlHub(), RobotConstants.Intake.left);
    public final NextCRServo right_servo = new NextCRServo(RobotController.controlHub(), RobotConstants.Intake.right);

    public void init(){
        left_servo.enable();
        right_servo.enable();
        left_servo.setDirection(NextMotor.Direction.REVERSE);
        right_servo.setDirection(NextMotor.Direction.FORWARD);
    }

    public Command spinIntake(){
        return Command.build().requiring(this).setStart(() -> {
            left_servo.setPower(1);
            right_servo.setPower(1);
        });
    }

}
