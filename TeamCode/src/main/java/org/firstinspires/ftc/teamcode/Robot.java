package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.Storage;
import org.firstinspires.ftc.teamcode.subsystems.Transfer;

import java.util.Set;

import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.NextRobot;

public class Robot implements NextRobot {

    public final Drivebase drivebase = new Drivebase();
    public final Transfer transfer = new Transfer();
    public final Shooter shooter = new Shooter();
    public final Intake intake = new Intake();
    public final Storage storage = new Storage();
    public boolean hasInit;
    public Robot(){
        hasInit = false;
    }

    public void init(){
        drivebase.init();
        transfer.init();
        shooter.init();
        intake.init();
        storage.init();
    }
    public Intake getIntake(){return intake;}
    public Transfer getTransfer(){return transfer;}
    public Shooter getShooter() {return shooter;}
    public Storage getStorage(){return storage;}
//    public Command getCurrentCommand(){
//        return SchedulerHook
//    }

    public Command startDrive(Gamepad gamepad) {return (drivebase.startDrive(gamepad));}
    @NonNull
    @Override
    public Set<Mechanism> getMechanisms() {
        return Set.of(drivebase);
    }
    public void periodic() {}

}
