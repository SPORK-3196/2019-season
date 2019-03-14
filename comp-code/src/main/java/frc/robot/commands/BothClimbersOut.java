/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BothClimbersOut extends Command {
  public BothClimbersOut() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.climb);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.climbing = true;
    System.out.println("Both climbers out!");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean frontLimit = Robot.climb.frontClimb.getSensorCollection().isRevLimitSwitchClosed();
    boolean rearLimit = Robot.climb.rearClimb.getSensorCollection().isRevLimitSwitchClosed();
    Robot.climb.frontClimb.set(rearLimit ? -0.4 : -0.7);
    Robot.climb.rearClimb.set(frontLimit ? -0.4 : -0.7);

    //System.out.print(Robot.climb.frontClimb.getSensorCollection().getAnalogIn());
    //System.out.print("\t");
    //System.out.println(Robot.climb.rearClimb.getSensorCollection().getAnalogIn());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.climb.frontClimb.getSensorCollection().isRevLimitSwitchClosed() && Robot.climb.rearClimb.getSensorCollection().isRevLimitSwitchClosed());
    //return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("Finished lifting!");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
