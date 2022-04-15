// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;







import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Victor;






/**
 * The VM is configured to automatically run this class, and to call the functions correspondingto
 * each mode, as described in the TimedRobot documentation. If you change the name of this class  or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

Victor frontleft = new Victor(1) ;
Victor frontright = new Victor(0);
Victor backleft = new Victor(3);
Victor backright = new Victor(2);

Victor intake = new Victor(4);
Victor leftshooter = new Victor(5);
Victor rightshooter = new Victor(6);
Victor feeder = new Victor(7);

MotorControllerGroup leftmotor = new MotorControllerGroup(frontleft, backleft) ;
MotorControllerGroup rightmotor = new MotorControllerGroup(frontright, backright) ;

Compressor comp = new Compressor(PneumaticsModuleType.CTREPCM) ;
DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0,1) ;

DifferentialDrive drive = new DifferentialDrive(leftmotor, rightmotor);

Timer timer = new Timer();

Joystick Ps4 = new Joystick(0) ;
Joystick stick = new Joystick(1);



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    comp.enableDigital();
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
    timer.reset();
    timer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
   if(timer.get()<3){
    leftmotor.set(0.20);
    rightmotor.set(0.20);
     } 
  else if(timer.get() > 3 && timer.get() < 5){
    comp.enableDigital(); 
    solenoid.set(Value.kReverse);
     }
  else if(timer.get()>=6 && timer.get()<7){
    intake.set(1);
    feeder.set(-1);
    }
  else if(timer.get()<9 && timer.get()>=7){
    leftshooter.set(-0.80);
    rightshooter.set(-1);
    }
  else if(timer.get()>10){
    intake.set(0);
    feeder.set(0);
    leftshooter.set(0);
    rightshooter.set(0);
    comp.disable();
    solenoid.set(Value.kForward);
  }
    
    
    }
  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
  
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(- Ps4.getRawAxis(1)*0.60, Ps4.getRawAxis(4)*0.60) ;
     
    
  
  if(Ps4.getRawButton(1)){
    intake.set(1);
    } 

  else if(Ps4.getRawButtonReleased(1)){
    intake.set(0);
    }

  else if(Ps4.getRawButton(2)){
    intake.set(-1);
    }
    
  else if(Ps4.getRawButtonReleased(2)){
    intake.set(0);
  }  
  
    

  if(Ps4.getRawButton(6)){
    leftshooter.set(0.70);
    rightshooter.set(0.70);  }
  else if(Ps4.getRawButtonReleased(6)){
    leftshooter.set(0);
    rightshooter.set(0);
  }
  else if(stick.getRawButton(2)){
    leftshooter.set(-0.70);
    rightshooter.set(-0.70);
  }
  else if(stick.getRawButtonReleased(2)){
    leftshooter.set(0);
    rightshooter.set(0);
  }

  if(Ps4.getRawButton(3)){
    feeder.set(0.50);
  }
  else if(Ps4.getRawButtonReleased(3)){
    feeder.set(0);
  }
  else if(Ps4.getRawButton(4)){
    feeder.set(-0.50);
  }
  else if(Ps4.getRawButtonReleased(4)){
    feeder.set(0);
  }
  
  if(stick.getTrigger()){
    solenoid.set(DoubleSolenoid.Value.kForward);
  }
  else if(stick.getRawButton(3)){
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }
  if(stick.getRawButton(4)){
    comp.enableDigital();
  }
  else if(stick.getRawButton(5)){
    comp.disable();
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