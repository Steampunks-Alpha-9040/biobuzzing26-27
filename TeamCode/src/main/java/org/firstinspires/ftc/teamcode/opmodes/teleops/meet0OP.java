package org.firstinspires.ftc.teamcode.opmodes.teleops;

import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

import static com.pedropathing.ivy.groups.Groups.*;

import org.firstinspires.ftc.teamcode.PipeBomb;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "Meet 0")
public class meet0OP extends NextOpMode {
    private PipeBomb robot;
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();
    private final Pose startPose = p.of(24, 24, 0);
    private final Pose park = p.of(48, 48, 90);

    private final Pose controlPose = p.of(36, 60, 45);

    private Path park() {
        return line(startPose, park).linear(startPose, park);
    }

    public void init(){
        Scheduler.reset();

        follower = Constants.create(hardwareMap);
        follower.setPose(startPose);
    }
    public meet0OP(PipeBomb robot) {
        super(robot);
        this.robot = robot;
        robot.init();
    }

    public void start(){
        CommandGamepad driver = new CommandGamepad(gamepad1);
        robot.startDrive(gamepad1).schedule();
        driver.a().onTrue(robot.getShooter().shoot());
        driver.b().onTrue(robot.getShooter().stop());
        driver.dpadRight().onTrue(robot.getShooter().deltaUp());
        driver.dpadLeft().onTrue(robot.getShooter().deltaDown());

        driver.rightBumper().whileTrue(robot.getIntake().spinIntakeForward());

        driver.rightTrigger().isBetween(0.5,1).onTrue(robot.getTransfer().spinTransferForward()).onFalse(robot.getTransfer().setTransferZeroPower());

        driver.leftBumper().whileTrue(robot.getIntake().spinIntakeBackward());

        driver.leftTrigger().isBetween(0.5,1).onTrue(robot.getTransfer().spinTransferBackward()).onFalse(robot.getTransfer().setTransferZeroPower());

        driver.dpadUp().onTrue(robot.getShooter().moveHoodForward());

        driver.dpadDown().onTrue(robot.getShooter().moveHoodBackward());
    }

    @Override
    public void periodic() {
        Telemetry.log("Status", "Running");
        Telemetry.log("Battery V", RobotController.getInputVoltage().getMagnitude());
        Telemetry.log("Shooter target", robot.getShooter().getTargetVelocity());
        Telemetry.log("Shooter velocity", robot.getShooter().getCurrentVelocity());
        Telemetry.log("Shooter at speed", robot.getShooter().isAtVelocity());
        Telemetry.log("Shooter master A", robot.getShooter().master.getCurrent().getMagnitude());
        Telemetry.log("Shooter slave A", robot.getShooter().slave.getCurrent().getMagnitude());
    }
}
