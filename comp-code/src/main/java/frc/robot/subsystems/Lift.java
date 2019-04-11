/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.commands.LiftWithJoystick;
import edu.wpi.first.wpilibj.Servo;

/**
 * Add your docs here.
 */
public class Lift extends PIDSubsystem {
  /**
   * Add your docs here.
   */

  public int offset = 0;

  public WPI_TalonSRX liftMotor = new WPI_TalonSRX(10);

  public Servo cameraServo = new Servo(0);

  public int getEncoder() {
    return liftMotor.getSelectedSensorPosition() - offset;
  }

  public void resetEncoder() {
    offset = liftMotor.getSelectedSensorPosition();
  }

  public void resetEncoderTo(int val) {
    offset = liftMotor.getSelectedSensorPosition() - val;
  }
  
  public Lift() {
    // Intert a subsystem name and PID values here
    super("Lift", 0.0010, 0, 0.001);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    setSetpoint(0);
    disable();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LiftWithJoystick());
  }

  @Override
  public double returnPIDInput() {
    return getEncoder();
  }

  @Override
  public void usePIDOutput(double val) {
    liftMotor.set(-val);
  }
}
