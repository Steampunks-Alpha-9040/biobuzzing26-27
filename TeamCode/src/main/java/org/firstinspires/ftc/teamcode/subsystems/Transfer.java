package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Transfer implements Mechanism {
    public Transfer(){}
    public final NextMotor transferRoller = new NextMotor(RobotController.controlHub(), 2);
//    public final NextCRServo rollerNearIntake = new NextCRServo(RobotController.controlHub(),3);
//    public final NextCRServo leftStorage = new NextCRServo(RobotController.controlHub(),4);
//    public final NextCRServo rightStorage = new NextCRServo(RobotController.controlHub(),0);

    public void init(){
        transferRoller.setDirection(NextMotor.Direction.FORWARD);
        transferRoller.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.BRAKE);
//        rollerNearIntake.enable();
//        rollerNearIntake.setDirection(NextMotor.Direction.FORWARD);
//        leftStorage.enable();
//        leftStorage.setDirection(NextMotor.Direction.FORWARD);
//        rightStorage.enable();
//        rightStorage.setDirection(NextMotor.Direction.REVERSE);
    }

//    public Command spinStorageForward(){
//        return Command.build().requiring(this).setStart(() -> {
//            rollerNearIntake.setPower(1);
//            leftStorage.setPower(1);
//            rightStorage.setPower(1);
//        });
//    }
//
//    public Command spinStorageBackward(){
//        return Command.build().requiring(this).setStart(() -> {
//            rollerNearIntake.setPower(-1);
//            leftStorage.setPower(-1);
//            rightStorage.setPower(-1);
//        });
//    }

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
