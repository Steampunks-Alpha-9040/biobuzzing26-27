package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.subsystems.Drivebase;

public class ExampleOpMode extends BaseOpMode {

    private Drivebase drivebase;

    public ExampleOpMode(){
        super();
        drivebase = Drivebase.getInstance();


    }



    @Override public void onInit() { }
    @Override public void onWaitForStart() { }
    @Override public void onStartButtonPressed() { }
    @Override public void onUpdate() { }
    @Override public void onStop() { }
}
