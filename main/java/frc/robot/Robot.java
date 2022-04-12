// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
 
 
  /* Motor sürücülerini 
    Motorları
    Kontrolcüyü ve sürüş tarzını tanımladım*/
 
  Victor frontright = new Victor(1) ;    
  Victor frontleft = new Victor(0) ;
  Victor backright = new Victor(3) ;
  Victor backleft = new Victor(2) ;

  Victor intake = new Victor(4);
  Victor left_shooter = new Victor(6);
  Victor right_shooter = new Victor(7);
  Victor feeder = new Victor(5);

  MotorControllerGroup leftmotor = new MotorControllerGroup(frontleft,backleft) ;
  MotorControllerGroup rightmotor = new MotorControllerGroup(frontright, backright) ;

  Joystick xbox = new Joystick(1) ;

  DifferentialDrive drive = new DifferentialDrive(leftmotor,rightmotor) ;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
   
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
   
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    
    
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    
    drive.arcadeDrive(xbox.getRawAxis(1), xbox.getRawAxis(0));

  
  if(xbox.getRawButton(1)){     //Eğer "1" tuşuna basılırsa intake 1 güçte çalışacaktır
    intake.set(1);
  }
  else if(xbox.getRawButtonReleased(1)){  //Eğer "1" tuşuna basılmazsa intake çalışmayacaktır
    intake.set(0);
  }
  else if(xbox.getRawButton(2)){     //Eğer "2" tuşuna basılırsa intake zıttı yönde çalışacaktır
    intake.set(-1);
  }
  else if(xbox.getRawButtonReleased(2)) {    //Eğer "2" tuşuna basılmazsa intake çalışmayacaktır
    intake.set(0) ;
  }



  if(xbox.getRawButton(3)) { //Eğer "3" tuşuna basılırsa atıcılar 0.75 güçte çalışacaktır
    left_shooter.set(0.75);
    right_shooter.set(0.75);
  }  
  else if(xbox.getRawButtonReleased(3)) { //Eğer "3" tuşuna basılmazsa atıcılar çalışmayacaktır
    left_shooter.set(0);
    right_shooter.set(0);
  }
  else if(xbox.getRawButton(4)){     //Eğer "4" tuşuna basılırsa atıcılar 0.75 gücünde zıt yönde çalışacaktır
    left_shooter.set(-0.75);
    right_shooter.set(-0.75);
  }
  else if(xbox.getRawButtonReleased(4)) {  //Eğer "4" tuşuna basılmazsa atıcılar çalışmayacaktır
    left_shooter.set(0);
    right_shooter.set(0);
  }




  if(xbox.getRawButton(5)){       //Eğer "5" tuşuna basılırsa feederlar 0.50 gücünde çalışacaktır
    feeder.set(0.50);
  }
  else if(xbox.getRawButtonReleased(5)){ //Eğer "5" tuşuna basılmazsa feederlar çalışmayacaktır
    feeder.set(0);
  }
  else if(xbox.getRawButton(6)){     //Eğer "6" tuşuna basılırsa feederlar 0.50 gücünde zıt yönde çalışacaktır
    feeder.set(-0.50);
  }
  else if(xbox.getRawButtonReleased(6)){   //Eğer "6" tuşuna basılmazsa feederlar çalışmayacaktır
    feeder.set(0);
  }




  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
