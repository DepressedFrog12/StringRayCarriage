// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Elevator;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator.ElevatorIO;
import frc.robot.subsystems.Elevator.ElevatorIO.ElevatorInputs;

/** Add your docs here. */
public class ElevatorSubsystem extends SubsystemBase {
    ElevatorIO io;
    ElevatorInputs data = new ElevatorInputs();
    

    public ElevatorSubsystem(ElevatorIO elevatorIO) {
        switch (Constants.RobotConstants.currentStatus) {
            case REAL:
                io = elevatorIO;
                break;
            case SIM:
                io = elevatorIO;
                break;
        }

    }

    public void periodic() {
        io.updateInputs();
        io.setVolts();

    }
}