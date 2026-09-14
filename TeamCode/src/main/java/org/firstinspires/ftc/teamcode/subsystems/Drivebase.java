package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Constants;

import dev.nextftc.control.drive.MecanumKinematics;
import dev.nextftc.hardware.actuators.NextMotor;
import dev.nextftc.robot.Mechanism;
import dev.nextftc.robot.drive.DriveCommands;


public class Drivebase implements Mechanism {

    private static Drivebase drivebase;

    private NextMotor FR;
    private NextMotor FL;
    private NextMotor BR;
    private NextMotor BL;
    private GoBildaPinpointDriver odo;

    private Follower follower;

    public Drivebase(){
        FR = new NextMotor(Constants.FR);
        FL = new NextMotor(Constants.FL);
        BR = new NextMotor(Constants.BR);
        BL = new NextMotor(Constants.BL);
    }

    @Override
    public void periodic() {
     MecanumKinematics   follower.update();
    }

    public void drive(Gamepad joy){
        DriveCommands.mecanumDriveFieldCentric(FL, FR, BL /*hehe*/, BR, joy, () -> odo.getHeading(AngleUnit.RADIANS), );
    }

    public static Drivebase getInstance(){
        if (drivebase == null){
            drivebase = new Drivebase();
        }
        return drivebase;
    }

    private MecanumKinematics getKinematics(){
        return new Me
    }







}
