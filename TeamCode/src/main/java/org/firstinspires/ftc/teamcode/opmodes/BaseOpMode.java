package org.firstinspires.ftc.teamcode.opmodes;


import org.firstinspires.ftc.teamcode.Robot;

import dev.nextftc.robot.opmode.BulkReadHook;
import dev.nextftc.robot.opmode.NextOpMode;

public abstract class BaseOpMode extends NextOpMode {
    public BaseOpMode(Robot mybot){
        super(mybot, BulkReadHook.INSTANCE);
    }

}
