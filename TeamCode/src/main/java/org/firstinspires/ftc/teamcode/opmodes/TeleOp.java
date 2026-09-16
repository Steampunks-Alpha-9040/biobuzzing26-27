package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.subsystems.Drivebase;
import org.firstinspires.ftc.teamcode.subsystems.Flywheel;

import dev.nextftc.robot.drive.DriveCommands;
import dev.nextftc.robot.opmode.NextTeleop;
import dev.nextftc.robot.triggers.CommandGamepad;

@NextTeleop(name = "default op mode")
public class TeleOp extends BaseOpMode {


    private final Robot bot;
    public TeleOp(Robot bot, Robot bot1){
        super(bot);
        this.bot = bot1;

    }

    public void start(){
        CommandGamepad driver = new CommandGamepad(gamepad1);

        driver.a().onTrue(bot.flywheel.runFlywheel());

    }




}
