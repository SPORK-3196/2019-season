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

public class RetractIntake extends Command {
  public RetractIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Retracting intake to begin climbing...");
    Robot.climbing = true;
    Robot.arm.armPID.setReference(0, ControlType.kPosition);
    Robot.arm.wristPID.setReference(0, ControlType.kPosition);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.arm.armPID.setReference(0, ControlType.kPosition);
    Robot.arm.wristPID.setReference(0, ControlType.kPosition);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.climbing;
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
