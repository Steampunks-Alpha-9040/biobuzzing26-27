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

    public final Drivebase drivebase = new Drivebase();
    public final Intake intake = new Intake();

    public PipeBomb(){

    }

    public Command startDrive(Gamepad gamepad1) {
        return DriveCommands.mecanumDrive(
                drivebase.frontLeft,
                drivebase.frontRight,
                drivebase.backLeft,
                drivebase.backRight,
                gamepad1
        );
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
