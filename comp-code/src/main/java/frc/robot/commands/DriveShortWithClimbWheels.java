/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveShortWithClimbWheels extends Command {
  public int initEncoder;
  public DriveShortWithClimbWheels() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.climb.rearClimbWheels.set(0);
    initEncoder = Robot.climb.rearClimbWheels.getSelectedSensorPosition();
    System.out.println("Started Driving Forward a Litle Bit");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climb.rearClimbWheels.set(0.4);
   // System.out.println(Robot.climb.rearClimbWheels.getSelectedSensorPosition());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.abortClimb || (Math.abs(Robot.climb.rearClimbWheels.getSelectedSensorPosition() - initEncoder) > 5000);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climb.rearClimbWheels.set(0.0);
    System.out.println("Finished");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
