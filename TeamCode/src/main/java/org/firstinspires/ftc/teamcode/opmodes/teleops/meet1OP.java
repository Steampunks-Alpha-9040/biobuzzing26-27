package org.firstinspires.ftc.teamcode.opmodes.teleops;

import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

import org.firstinspires.ftc.teamcode.PipeBomb;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import dev.nextftc.hardware.RobotController;
import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "Meet 1")
public class meet1OP extends NextOpMode {
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
    public meet1OP(PipeBomb robot) {
        super(robot);
        this.robot = robot;
        robot.init();
    }

    public void start(){
        CommandGamepad driver = new CommandGamepad(gamepad1);

        robot.startDrive(gamepad1).schedule();

        driver.a().onTrue(robot.getShooter().shoot(5000));
        driver.b().onTrue(robot.getShooter().stop());

        driver.rightBumper().whileTrue(robot.getIntake().intake().with(robot.getStorage().spinStorageBackward()));
        driver.leftBumper().whileTrue(robot.getIntake().outtake().with(robot.getStorage().spinStorageForward()));

        driver.rightTrigger().isBetween(0.5,1).toggleOnTrue(robot.getIntake().intake());
        driver.leftTrigger().isBetween(0.5,1).toggleOnTrue(robot.getIntake().outtake());

        driver.dpadUp().onTrue(robot.getTransfer().spinTransferForward());
        driver.dpadDown().onTrue(robot.getTransfer().spinTransferBackward());



    }

    @Override
    public void periodic() {
        Telemetry.log("Status", "Running");
        Telemetry.log("Battery V", RobotController.getInputVoltage().getMagnitude());
        Telemetry.log("Shooter at speed", robot.getMechanisms().size());
    }
}
