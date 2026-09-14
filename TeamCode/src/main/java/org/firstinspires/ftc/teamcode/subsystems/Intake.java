package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;

import org.firstinspires.ftc.teamcode.Constants;

import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;

public class Intake implements Mechanism {

    private static Intake intake;

    private NextMotor intake_motor;

    private Intake(){
        intake_motor = new NextMotor(Constants.Intake.intake_motor);
    }

    public Command intake(){
        return instant(() -> intake_motor.setThrottle(1.0));
    }



    public static Intake getInstance(){
        if (intake == null){
            intake = new Intake();
        }
        return intake;
    }
}
