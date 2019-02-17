/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {

  public static XboxController controller0 = new XboxController(0);

  // Standard drive systems
  public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(3);
  public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(1);
  public static WPI_TalonSRX frontRight = new WPI_TalonSRX(4);
  public static WPI_TalonSRX rearRight = new WPI_TalonSRX(2);
  public static SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, rearLeft);
  public static SpeedControllerGroup right = new SpeedControllerGroup(frontRight, rearRight);
  public static DifferentialDrive drive = new DifferentialDrive(left, right);

  // Middle wheel
  public static WPI_TalonSRX middleLeft = new WPI_TalonSRX(5);
  public static WPI_TalonSRX middleRight = new WPI_TalonSRX(6);
  public static SpeedControllerGroup middle = new SpeedControllerGroup(middleLeft, middleRight);

  // Intake
  public static WPI_TalonSRX intake = new WPI_TalonSRX(7);

  // Washer + Shooter
  public static WPI_TalonSRX washer = new WPI_TalonSRX(8);
  public static WPI_TalonSRX shooter = new WPI_TalonSRX(9);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    drive.arcadeDrive(-controller0.getRawAxis(1), controller0.getRawAxis(0));
    middle.set(-controller0.getRawAxis(4));
    
    intake.set(0.5*controller0.getRawAxis(2));

    washer.set(-controller0.getRawAxis(3));
    shooter.set(controller0.getRawAxis(3));
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
