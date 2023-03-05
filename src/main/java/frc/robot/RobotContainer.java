// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

// import frc.robot.subsystems.Solenoid;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private CommandXboxController xboxController = new CommandXboxController(1);
  private Candle candle = new Candle();
  // private final Solenoid solenoid = new Solenoid();
  //private只能在這裡被找到，去Arm或Chassis就找不到了
  //Double Solenoid若未被偵測到deploy時會報錯
  
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public RobotContainer(){
    configureButtonBindings();
    chassis();
    candlemove();
  }
  private void chassis(){  
    // chassis.setDefaultCommand(Commands.run(() -> {chassis.move(                   
    //                                               joystick.getY()*0.6,   
    //                                               joystick.getZ()*0.5);},
    //                                               chassis));
                                                  //move的參數放進中間藍色小括號                                                
  }
  private void candlemove(){
    candle.setDefaultCommand(Commands.run(() -> candle.move_light(xboxController.getLeftY()),candle));
  }

  private void configureButtonBindings() {

    // new JoystickButton(joystick, 8)      .onTrue(Commands.either(Commands.run(candle::red,candle), Commands.run(candle::l_stop, candle), Robot.aaa));
    xboxController.b()     .whileTrue(Commands.run(candle::red, candle));

    xboxController.a()     .whileTrue(Commands.run(candle::green, candle));

    xboxController.x()     .whileTrue(Commands.run(candle::blue, candle));

    xboxController.y()     .whileTrue(Commands.run(candle::a_strobe, candle));

                                
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  }
  Command getAutonomousCommand() {
    return null;
  }
}