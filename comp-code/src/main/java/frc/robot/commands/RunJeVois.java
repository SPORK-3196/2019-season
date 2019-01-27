/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.SerialPort.Port;

public class RunJeVois extends Command {
  public RunJeVois() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.jevois);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Initialize serial interface with JeVois
    /*Robot.jevois.port = new SerialPort(115200, Port.kUSB1);
    Robot.jevois.port.writeString("hello");
    Robot.jevois.port.flush();*/

    Robot.jevois.cam = CameraServer.getInstance().startAutomaticCapture();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*if(Robot.jevois.port.getBytesReceived() > 0) {
      System.out.println(Robot.jevois.port.readString());
    }*/
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
