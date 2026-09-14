package org.firstinspires.ftc.teamcode.subsystems;



import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.Constants;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.units.Units;
import dev.nextftc.units.measuretypes.AngularVelocity;

public class Flywheel implements Mechanism {
    private static Flywheel flywheel;
    private NextMotor fly_motor;

    private Flywheel(){
        fly_motor = new NextMotor(Constants.Flywheel.fly_motor);
    }

    public Command runFlywheel() {
        return instant(() -> fly_motor.setVelocitySetpoint(new AngularVelocity(500, Units.RotationsPerSecond)));
    }

    public static Flywheel getInstance(){
        if (flywheel == null){
            flywheel = new Flywheel();
        }
        return flywheel;
    }
}
