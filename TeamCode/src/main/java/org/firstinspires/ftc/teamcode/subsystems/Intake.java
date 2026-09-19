package org.firstinspires.ftc.teamcode.subsystems;

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

    }

}
