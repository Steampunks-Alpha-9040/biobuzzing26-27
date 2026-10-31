package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Transfer implements Mechanism {
    public Transfer(){}
    public final NextMotor transferRoller = new NextMotor(RobotController.controlHub(), 2);

    public void init(){
        transferRoller.setDirection(NextMotor.Direction.FORWARD);
        transferRoller.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
    }

    @NonNull
    public Command getDefaultCommand() {
        return infinite(() -> {
            transferRoller.setThrottle(0);
        });
    }

    public Command spinTransferForward(){
        return Command.build().requiring(this).setStart(() -> {
           transferRoller.setThrottle(1);
        });
    }

    public Command spinTransferBackward(){
        return Command.build().requiring(this).setStart(() -> {
            transferRoller.setThrottle(-1);
        });
    }

    public Command setTransferZeroPower(){
        return Command.build().requiring(this).setStart(() ->{
            transferRoller.setThrottle(0);
        });
    }
}
