package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class Turret implements Mechanism {
    public Turret() {}
    public final NextCRServo turretServo1 = new NextCRServo(RobotController.controlHub(),4);
    public final NextCRServo turretServo2 = new NextCRServo(RobotController.controlHub(),5);

    public void init(){
        turretServo1.enable();
        turretServo2.enable();
        turretServo1.setDirection(NextMotor.Direction.FORWARD);
        turretServo2.setDirection(NextMotor.Direction.FORWARD);
    }

    public Command spinTurretForward(){
        return Command.build().requiring(this).setStart(() -> {
            turretServo1.setPower(1);
            turretServo2.setPower(1);
        });
    }

    public Command spinTurretBackward(){
        return Command.build().requiring(this).setStart(() -> {
            turretServo1.setPower(1);
            turretServo2.setPower(1);
        });
    }

}
