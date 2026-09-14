package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Drivebase;

import dev.nextftc.robot.opmode.NextTeleop;

@NextTeleop(name = "default op mode")
public class TeleOp extends BaseOpMode {

    private Drivebase drivebase;

    public TeleOp(Robot bot){
        super(bot);
        drivebase = Drivebase.getInstance();

    }



    @Override public void onInit() { }
    @Override public void onWaitForStart() { }
    @Override public void onStartButtonPressed() { }
    @Override public void onUpdate() { }
    @Override public void onStop() { }
}
