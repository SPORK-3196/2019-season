/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveWithJoystick extends Command {
  public DriveWithJoystick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double driveSpeed = -1*Robot.controller0.getRawAxis(1);
    double driveRotation = 1*Robot.controller0.getRawAxis(0);
    Robot.drive.drive.arcadeDrive(driveSpeed, driveRotation);

    int encoderL = Robot.drive.frontLeft.getSelectedSensorPosition();
    int encoderR = Robot.drive.frontRight.getSelectedSensorPosition();
    System.out.print(encoderL);
    System.out.print("\t\t");
    System.out.println(encoderR);
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
