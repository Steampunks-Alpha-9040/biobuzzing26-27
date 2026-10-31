package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Command.*;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.util.PIDControl;
import org.firstinspires.ftc.teamcode.util.Util;

import java.util.Map;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Shooter implements Mechanism {

    public Shooter(){}
    public final NextMotor master = new NextMotor(RobotController.controlHub(), 2);
    public final NextMotor slave = new NextMotor(RobotController.controlHub(), 3);
//    public final NextCRServo hood = new NextCRServo(RobotController.controlHub(), 4);



    private final PIDControl flywheelCalculator = new PIDControl(
            Constants.FlywheelConstants.flywheel_kP,
            Constants.FlywheelConstants.flywheel_kI,
            Constants.FlywheelConstants.flywheel_kD,
            Constants.FlywheelConstants.flywheel_kF,
            Constants.FlywheelConstants.flywheelVelocityTolerance
    );

    public void init(){
        master.setDirection(NextMotor.Direction.FORWARD);
        slave.setDirection(NextMotor.Direction.FORWARD);
    }

    public void periodic(){
        double flywheelCurrentRPM = -master.getEncoderVelocity().getBaseUnitMagnitude()/ Util.GoBILDA.BARE.getCPR() * 60;

        double power = flywheelCalculator.calculate(flywheelCurrentRPM);

        master.setThrottle(power);
        slave.setThrottle(power);
    }

    public Command shoot(){
        return instant(() -> flywheelCalculator.setSetpoint(5000));
    }
    public Command stop(){
        return instant(() -> flywheelCalculator.setSetpoint(0));
    }

//    public Command moveHoodForward(){
//        return Command.build().requiring(this).setStart(() -> {
//            hood.setPower(1);
//        });
//    }
//
//    public Command moveHoodBackward(){
//        return Command.build().requiring(this).setStart(() -> {
//            hood.setPower(-1);
//        });
//    }
}
