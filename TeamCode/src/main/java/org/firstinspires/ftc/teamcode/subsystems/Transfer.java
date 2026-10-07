package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Transfer implements Mechanism {
    public Transfer(){}
    public final NextCRServo transferRoller = new NextCRServo(RobotController.controlHub(), 3);

    public void init(){
        transferRoller.enable();
        transferRoller.setDirection(NextMotor.Direction.FORWARD);
    }

    public Command spinTransferForward(){
        return Command.build().requiring(this).setStart(() -> {
           transferRoller.setPower(1);
        });
    }

    public Command spinTransferBackward(){
        return Command.build().requiring(this).setStart(() -> {
            transferRoller.setPower(-1);
        });
    }
}
