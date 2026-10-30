package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.Transfer;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;
import dev.nextftc.robot.drive.DriveCommands;

public class PipeBomb implements NextRobot {

    public final Drivebase drivebase = new Drivebase();
    public final Transfer transfer = new Transfer();
    public final Shooter shooter = new Shooter();

    public boolean hasInit;
    public PipeBomb(){
        hasInit = false;
    }

    public void init(){
        drivebase.init();
        transfer.init();
        shooter.init();
    }

    public Transfer getTransfer(){return transfer;}

    public Shooter getShooter() {return shooter;}

    public Command startDrive(Gamepad gamepad) {return (drivebase.startDrive(gamepad));}


    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(drivebase);
    }
    public void periodic() {}

}
