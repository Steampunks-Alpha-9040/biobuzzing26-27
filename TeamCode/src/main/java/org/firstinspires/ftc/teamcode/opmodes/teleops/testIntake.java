package org.firstinspires.ftc.teamcode.opmodes.teleops;

import org.firstinspires.ftc.teamcode.PipeBomb;

import dev.nextftc.robot.Telemetry;
import dev.nextftc.robot.opmode.NextOpMode;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;


@NextTeleop(group = "testing", name = "intake")
public class testIntake extends NextOpMode {

    private PipeBomb robot;
    public testIntake(PipeBomb robot) {
        super(robot);
        this.robot = robot;
        robot.init();
    }

    public void start(){
        CommandGamepad driver = new CommandGamepad(gamepad1);

        driver.a().whileTrue(robot.getIntake().spinIntake());
    }

    @Override
    public void periodic() {
        Telemetry.log("Status", "Running");
        telemetry.update();
    }

}
