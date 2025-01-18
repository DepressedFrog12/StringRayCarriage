// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Elevator.ElevatorIO;

public class IntakeSubsystem extends SubsystemBase {
  
  IntakeIO io;
  IntakeIOInputsAutoLogged inputs = new IntakeIOInputsAutoLogged();

  private static IntakeSubsystem instance;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem(IntakeIO intakeIO) {
    io = intakeIO;
    
  }

public static IntakeSubsystem getInstance() {
    if (instance == null) {
      instance = new IntakeSubsystem(new IntakeIOSim());
    }
    return instance;
  }

  
  public void setRPM(AngularVelocity rpm, SimpleMotorFeedforward feedforward) {
    io.setRollerRPM(rpm, feedforward);
  }

  @Override
  public void periodic() {
    
    io.processInputs(inputs);
    Logger.processInputs("Intake", inputs);
  }
}
