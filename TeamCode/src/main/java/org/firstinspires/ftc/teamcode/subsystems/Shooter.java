package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import java.util.Map;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Shooter implements Mechanism {

    public Shooter(){}
    public final NextMotor master = new NextMotor(RobotController.expansionHub(), 2);
    public final NextMotor slave = new NextMotor(RobotController.expansionHub(), 3);
    public final NextCRServo hood = new NextCRServo(RobotController.controlHub(), 0);


    public void init(){
        hood.enable();
        hood.setDirection(NextMotor.Direction.REVERSE);
        master.setDirection(NextMotor.Direction.FORWARD);
        slave.setDirection(NextMotor.Direction.FORWARD);
    }

    public Command shoot(){
        return Command.build().requiring(this).setStart(() -> {
            master.setThrottle(1);
            slave.setThrottle(1);
        });
    }

    public Command noShoot(){
        return Command.build().requiring(this).setStart(() -> {
            master.setThrottle(1);
            slave.setThrottle(1);
        });
    }

    public Command moveHoodForward(){
        return Command.build().requiring(this).setStart(() -> {
            hood.setPower(1);
        });
    }

    public Command moveHoodBackward(){
        return Command.build().requiring(this).setStart(() -> {
            hood.setPower(-1);
        });
    }
}
