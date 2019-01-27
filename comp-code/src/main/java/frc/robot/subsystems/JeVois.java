/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.RunJeVois;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.SerialPort;

/**
 * Add your docs here.
 */
public class JeVois extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Serial interface
  //public SerialPort port;

  // USB camera interface
  public UsbCamera cam;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new RunJeVois());
  }
}
