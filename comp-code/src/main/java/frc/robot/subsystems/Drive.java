/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Talon frontLeft = new Talon(1);
  public Talon rearLeft = new Talon(2);
  public SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, rearLeft);
  public Talon frontRight = new Talon(3);
  public Talon rearRight = new Talon(4);
  public SpeedControllerGroup right = new SpeedControllerGroup(frontRight, rearRight);
  public DifferentialDrive drive = new DifferentialDrive(left, right);
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveWithJoystick());
  }
}
