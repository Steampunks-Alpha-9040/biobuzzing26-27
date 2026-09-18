package org.firstinspires.ftc.teamcode.opmodes.teleops;

import org.firstinspires.ftc.teamcode.PipeBomb;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "My Teleop")
public class driveOP extends NextOpMode {

    private PipeBomb robot;
    public driveOP(PipeBomb robot) {
        super(robot);
        this.robot = robot;
    }

    public void start(){
        CommandGamepad driver = new CommandGamepad(gamepad1);
        robot.startDrive(gamepad1).schedule();

    }

    @Override
    public void periodic() {
        Telemetry.log("Status", "Running");
    }
}
