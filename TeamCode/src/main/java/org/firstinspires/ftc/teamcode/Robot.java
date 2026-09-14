package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import org.firstinspires.ftc.teamcode.subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.subsystems.Intake;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class Robot implements NextRobot {

    private Drivebase drivebase;
    private Flywheel flywheel;
    private Intake intake;

    public Robot() {
        drivebase = Drivebase.getInstance();
        flywheel = Flywheel.getInstance();
        intake = Intake.getInstance();
    }


    @Override
    public void periodic() {

    }
    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(
            drivebase,
            flywheel,
            intake
        );
    }
}
