// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.CarriageConstants;
import frc.robot.subsystems.Carriage.CarriageIOSparkMax;
import frc.robot.subsystems.Carriage.CarriageIOSim;
import frc.robot.subsystems.Carriage.CarriageIOTalonSRX;
import frc.robot.subsystems.Carriage.CarriageSubsystem;
import frc.robot.subsystems.Carriage.Commands.RunIntake;
import frc.robot.subsystems.Carriage.Commands.RunOuttake;
import frc.robot.Constants.CarriageConstants;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems

  // private final CANDriveSubsystem driveSubsystem = new CANDriveSubsystem();
  // private final CANRollerSubsystem rollerSubsystem = new CANRollerSubsystem();
  // The driver's controller
  private final CommandXboxController driverController = new CommandXboxController(0);

  // The autonomous chooser
  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    if (RobotBase.isSimulation()) {
      new CarriageSubsystem(new CarriageIOSim());
    } else if (Constants.CarriageConstants.motor == Constants.CarriageConstants.Motor.SPARKMAX) {
      new CarriageSubsystem(new CarriageIOSparkMax());
    } else {
      new CarriageSubsystem(new CarriageIOTalonSRX());
    }

    configureBindings();

  }
  // Set the options to show up in the Dashboard for selecting auto modes. If you
  // add additional auto modes you can add additional lines here with
  // autoChooser.addOption
  // autoChooser.setDefaultOption("Autonomous",
  // Autos.exampleAuto(driveSubsystem));
  // }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be
   * created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with
   * an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link
   * CommandXboxController
   * Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or
   * {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Set the A button to run the "runRoller" command from the factory with a fixed
    // // value ejecting the gamepiece while the button is held
    // driverController.a()
    // .whileTrue(rollerSubsystem.runRoller(rollerSubsystem, () ->
    // RollerConstants.ROLLER_EJECT_VALUE, () -> 0));

    // Set the default command for the drive subsystem to the command provided by
    // factory with the values provided by the joystick axes on the driver
    // controller. The Y axis of the controller is inverted so that pushing the
    // stick away from you (a negative value) drives the robot forwards (a positive
    // // value)
    // driveSubsystem.setDefaultCommand(
    // driveSubsystem.driveArcade(
    // driveSubsystem, () -> -driverController.getLeftY(), () ->
    // -driverController.getRightX()));

    // Set the default command for the roller subsystem to the command from the
    // // factory with the values provided by the triggers on the operator
    // controller
    // rollerSubsystem.setDefaultCommand(
    // rollerSubsystem.runRoller(
    // rollerSubsystem,
    // () -> driverController.getRightTriggerAxis(),
    // () -> driverController.getLeftTriggerAxis()));

    // Set the default command for the intake subsystem to the command from the
    // factory with the values provided by the triggers on the operator controller
    driverController.b().whileTrue(new RunIntake(CarriageConstants.maxPercent));
    driverController.y().whileTrue(new RunOuttake(CarriageConstants.maxPercent));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return autoChooser.getSelected();
  }
}
