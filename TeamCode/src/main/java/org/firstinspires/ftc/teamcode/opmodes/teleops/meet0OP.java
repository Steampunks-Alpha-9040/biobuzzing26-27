package org.firstinspires.ftc.teamcode.opmodes.teleops;

import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "Meet 0")
public class meet0OP extends NextOpMode {
    private Robot robot;

    public void init(){

    }
    public meet0OP(Robot robot) {
        super(robot);
        this.robot = robot;
    }

    public void start(){
        robot.init();
        CommandGamepad bombTechnician = new CommandGamepad(gamepad1);

        bombTechnician.a().toggleOnTrue(robot.getIntake().intake());
    }

    @Override
    public void periodic() {
        Telemetry.log("Status", "Running");
        Telemetry.log("Battery V", RobotController.getInputVoltage().getMagnitude());
        Telemetry.log("is active", "false");
    }
}
