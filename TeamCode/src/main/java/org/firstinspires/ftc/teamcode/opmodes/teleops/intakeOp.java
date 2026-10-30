package org.firstinspires.ftc.teamcode.opmodes.teleops;

import static com.pedropathing.api.Paths.line;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

import org.firstinspires.ftc.teamcode.PipeBomb;
import org.firstinspires.ftc.teamcode.pedro.Constants;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "Test Intake")
public class intakeOp extends NextOpMode {
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
    public intakeOp(PipeBomb robot) {
        super(robot);
        this.robot = robot;
        robot.init();
    }

    public void start(){
        CommandGamepad driver = new CommandGamepad(gamepad1);
        driver.a().whileTrue(robot.getIntake().spinIntakeForward());
        driver.b().whileTrue(robot.getIntake().spinIntakeBackward());

    }

    @Override
    public void periodic() {
        Telemetry.log("Status", "Running");
    }
}
