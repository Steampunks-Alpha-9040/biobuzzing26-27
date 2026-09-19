package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;
import dev.nextftc.robot.drive.DriveCommands;

public class PipeBomb implements NextRobot {

    private final Drivebase drivebase;
    private final Intake intake;

    public PipeBomb(){
        intake = new Intake();
        drivebase = new Drivebase();
    }

    public Drivebase getDrivebase(){
        return drivebase;
    }

    public Intake getIntake(){
        return intake;
    }

    public void init(){
        drivebase.init();
        intake.init();
    }

    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(drivebase);
    }
    public void periodic() {}

}
