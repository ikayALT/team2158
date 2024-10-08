// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SpinMotor;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.SpinMotorSub;

//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

//import frc.robot.commands.SpinMotor;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here. 
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final SpinMotorSub spinMotorSub = new SpinMotorSub();
  private final SpinMotor spinMotorCmd = new SpinMotor(spinMotorSub);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  //private final CommandJoystick m_driverController = new CommandJoystick(OperatorConstants.kDriverControllerPort);

  public static final Joystick kJoystick = new Joystick(0);
  private final Trigger shootTrigger = new JoystickButton(kJoystick, 1);
  //private final GenericHID m_stick = new GenericHID(0);
  
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    //while(true) {
    //  System.out.println(m_stick.getRawAxis(0) + ", " + m_stick.getRawAxis(1));
    //}
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    //new Trigger(spinMotorSub::startMotor).onTrue(new SpinMotor(spinMotorSub));
    //spinMotorSub.setDefaultCommand(spinMotorCmd);
    //randInt = spinMotorSub.periodic();
    shootTrigger.whileTrue(spinMotorCmd);




    // Schedule `exampleMethodCommand` when the Xbox cont roller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    
  }

  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
