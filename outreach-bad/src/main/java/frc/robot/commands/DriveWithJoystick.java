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
    //double driveCoef = Robot.lift.getEncoder() > 20000 ? 0.7 : 1.0;
    //double driveCoef = 0.9;
    double driveCoef = Robot.powerCoefficient.getDouble(0.5);

    double driveSpeed = -driveCoef*Robot.controller0.getRawAxis(1);
    double driveRotation = driveCoef*Robot.controller0.getRawAxis(0);

    Robot.drive.drive.arcadeDrive(driveSpeed, driveRotation);

    int encoderDL = Robot.drive.frontLeft.getSelectedSensorPosition();
    int encoderDR = Robot.drive.frontRight.getSelectedSensorPosition();
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
