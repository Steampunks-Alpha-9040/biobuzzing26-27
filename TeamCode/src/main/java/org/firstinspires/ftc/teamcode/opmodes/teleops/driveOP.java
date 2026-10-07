package org.firstinspires.ftc.teamcode.opmodes.teleops;

import org.firstinspires.ftc.teamcode.PipeBomb;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

import com.pedropathing.follower.Follower;

import org.firstinspires.ftc.teamcode.pedro.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import static com.pedropathing.api.Paths.*;

import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Scheduler;

@NextTeleop(name = "My Teleop")
public class driveOP extends NextOpMode {
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
    public driveOP(PipeBomb robot) {
        super(robot);
        this.robot = robot;
        robot.init();
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
