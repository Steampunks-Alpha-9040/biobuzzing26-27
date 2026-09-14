package org.firstinspires.ftc.teamcode.opmodes;


import dev.nextftc.robot.opmode.NextOpMode;

public abstract class BaseOpMode extends NextOpMode {
    public BaseOpMode(){
        super();
    }
    public FateComponent getLogger(){
        return FateComponent.INSTANCE;
    }
    public BulkReadComponent getBulkRead() {return BulkReadComponent.INSTANCE;}
}
