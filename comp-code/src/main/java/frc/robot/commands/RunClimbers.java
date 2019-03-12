/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RunClimbers extends Command {
  public RunClimbers() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.climb.frontClimb.set(0);
    Robot.climb.rearClimb.set(0);
    Robot.climb.rearClimbWheels.set(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double triggerL = Robot.controller0.getRawAxis(2);
    double triggerR = Robot.controller0.getRawAxis(3);
    boolean bumperL = Robot.controller0.getBumper(Hand.kLeft);
    boolean bumperR = Robot.controller0.getBumper(Hand.kRight);

    double frontClimbSpeed = bumperR ? 0.5 : triggerR * -0.6;
    double rearClimbSpeed = bumperL ? 0.5 : triggerL * -0.7;
    double rearClimbDriveSpeed = -Robot.controller0.getRawAxis(5)*0.7;

    Robot.climb.frontClimb.set(frontClimbSpeed);
    Robot.climb.rearClimb.set(rearClimbSpeed);
    Robot.climb.rearClimbWheels.set(rearClimbDriveSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
