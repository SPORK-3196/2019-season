/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunArm extends Command {
  public RunArm() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.arm.armMotor.set(0);
    Robot.arm.armPID.setP(0.05);
    Robot.arm.armPID.setI(0);
    Robot.arm.armPID.setD(0);
    Robot.arm.armPID.setOutputRange(-0.2, 0.2);

    Robot.arm.wristMotor.set(0);
    Robot.arm.wristPID.setP(0.1);
    Robot.arm.wristPID.setI(0);
    Robot.arm.wristPID.setD(0);
    Robot.arm.wristPID.setOutputRange(-0.4, 0.4);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //double wristSpeed = 0.4*Robot.controller1.getRawAxis(5);
    //double wristSpeed = Robot.controller1.getAButton() ? 0.4 : Robot.controller1.getBButton() ? -0.4 : 0;

    //Robot.arm.armMotor.set(armSpeed);
    //Robot.arm.wristMotor.set(wristSpeed);

    //if(Robot.climbing) {
      Robot.arm.armPID.setReference(0, ControlType.kPosition); 
      Robot.arm.wristPID.setReference(0, ControlType.kPosition);
    /*} else {
      Robot.arm.armPID.setReference((Robot.lift.getEncoder() / 2000) - 15, ControlType.kPosition);
      Robot.arm.wristPID.setReference(((Robot.arm.armEncoder + 15.0) * (8.5/15.0)) - 10, ControlType.kPosition);
    }*/

    //Robot.arm.armPID.setReference(-15, ControlType.kPosition);

    Robot.arm.armEncoder = Robot.arm.armMotor.getEncoder().getPosition();
    Robot.arm.wristEncoder = Robot.arm.wristMotor.getEncoder().getPosition();

    //System.out.println(((Robot.arm.armEncoder + 15.0) * (9.0/15.0)) - 9f);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.climbing;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //System.out.println("Finished using manual PID arm control...");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
