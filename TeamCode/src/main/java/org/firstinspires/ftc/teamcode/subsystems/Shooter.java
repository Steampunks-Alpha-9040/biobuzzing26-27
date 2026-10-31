package org.firstinspires.ftc.teamcode.subsystems;

import static dev.nextftc.units.Units.RotationsPerMinute;

import com.pedropathing.ivy.Command;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

// Ported from 13201 Hazmat's Launcher: uses NextMotor's built-in velocity control
// (kS + kV feedforward), which NextMotor updates every loop on its own.
public class Shooter implements Mechanism {
    public final NextMotor master = new NextMotor(RobotController.expansionHub(), 2);
    public final NextMotor slave = new NextMotor(RobotController.expansionHub(), 3);
    public final NextCRServo hood = new NextCRServo(RobotController.controlHub(), 4);

    // velocities are in NextMotor's units (default anglePerCount = 1 rad), same as Hazmat's
    private final double TOLERANCE = 25;
    private final double DELTA = 50.0;
    private final double POINT1 = 8000;

    public double kV = 0.0000571;
    public double kS = 0.16;

    private double targetVelocity = 0.0;

    public Shooter(){
        master.getVelocityConstants().setKV(kV);
        master.getVelocityConstants().setKS(kS);
    }

    public void init(){
        master.setDirection(NextMotor.Direction.FORWARD);
        slave.setDirection(NextMotor.Direction.FORWARD);
        master.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);
        slave.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);
        // both motors turn the flywheel the same way, so slave copies master's power
        slave.follow(master);
        hood.enable();
    }

    public void setTargetVelocity(double velocity){
        targetVelocity = velocity;
        master.setVelocitySetpoint(RotationsPerMinute.of(velocity));
    }

    public double getCurrentVelocity(){
        return master.getEncoderVelocity().into(RotationsPerMinute);
    }

    public double getTargetVelocity(){
        return targetVelocity;
    }

    public boolean isAtVelocity(){
        return Math.abs(getCurrentVelocity() - targetVelocity) <= TOLERANCE;
    }

    public Command shoot(){
        return instant(() -> setTargetVelocity(POINT1));
    }

    public Command stop(){
        return instant(() -> setTargetVelocity(0));
    }

    public Command deltaUp(){
        return instant(() -> setTargetVelocity(targetVelocity + DELTA));
    }

    public Command deltaDown(){
        return instant(() -> setTargetVelocity(targetVelocity - DELTA));
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
