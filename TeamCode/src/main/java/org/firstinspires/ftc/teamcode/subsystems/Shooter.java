package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.teamcode.util.Util.GoBILDA.BARE;
import static dev.nextftc.units.Units.Rotations;
import static dev.nextftc.units.Units.RotationsPerMinute;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.util.Util;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.hardware.actuators.NextCRServo;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.Telemetry;

// Ported from 13201 Hazmat's Launcher: uses NextMotor's built-in velocity control
// (kS + kV feedforward), which NextMotor updates every loop on its own.
public class Shooter implements Mechanism {
    public final NextMotor master = new NextMotor(RobotController.expansionHub(), 2);
    public final NextMotor slave = new NextMotor(RobotController.expansionHub(), 3);
    public final NextCRServo hood = new NextCRServo(RobotController.controlHub(), 4);

    // velocities are in NextMotor's units (default anglePerCount = 1 rad), same as Hazmat's
    private final double tolerance_RPM = 25;
    private final double DELTA = 50.0;
    private final double POINT1 = 5500;




    private double targetRPM = 0;

    public Shooter(){

    }

    public void init(){
        master.setDirection(NextMotor.Direction.FORWARD);
        slave.setDirection(NextMotor.Direction.FORWARD);
        master.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);
        slave.setZeroPowerBehavior(NextMotor.ZeroPowerBehavior.FLOAT);

        master.setAnglePerCount(Rotations.of((1.0 / BARE.getCPR()))); // i think this is right??

        slave.follow(master);
        hood.enable();
    }

    public void periodic(){
        Telemetry.log("Shooter/targetRPM", getTargetRPM());
        Telemetry.log("Shooter/actualRPM", getCurrentRPM());
    }

    @NonNull
    public Command getDefaultCommand() {
        return infinite(() -> setTargetRPM(0));
    }

    public void setTargetRPM(double velocity){
        targetRPM = velocity;
        master.setVelocitySetpoint(RotationsPerMinute.of(velocity));
    }

    public double getCurrentRPM(){
        return master.getEncoderVelocity().into(RotationsPerMinute);
    }

    public double getTargetRPM(){
        return targetRPM;
    }

    public boolean isAtVelocity(){
        return Util.isNear(targetRPM, getCurrentRPM(), tolerance_RPM);
    }

    public Command shoot(){
        return instant(() -> {
            setTargetRPM(POINT1);
            Telemetry.log("is active", "true");
        });
    }

    public Command stop(){
        return instant(() -> setTargetRPM(0));
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
