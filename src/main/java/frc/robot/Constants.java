// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;
import edu.wpi.first.units.measure.AngularVelocity;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static enum Mode { REAL, SIM };

  public static final Mode mode = Mode.REAL;


  public static final class DriveConstants {
    public static final int LEFT_LEADER_ID = 1;
    public static final int LEFT_FOLLOWER_ID = 2;
    public static final int RIGHT_LEADER_ID = 3;
    public static final int RIGHT_FOLLOWER_ID = 4;

    public static final int DRIVE_MOTOR_CURRENT_LIMIT = 60;
  }

  public static final class RollerConstants {
    public static final int ROLLER_MOTOR_ID = 5;
    public static final int ROLLER_MOTOR_CURRENT_LIMIT = 60;
    public static final double ROLLER_MOTOR_VOLTAGE_COMP = 10;
    public static final double ROLLER_EJECT_VALUE = 0.44;
  }

  public static final class OperatorConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
  }

  public static final class ElevatorConstants {
    public static final double gearing = 150.0/7.0;
    public static final double startingHeight = 0.0;
    public static final double elevatorCarriageMass = 0.0;
    public static final double[] elevatorHeight = new double[] {0.0, 2.0};
    public static final double elevatorDrumRadius = 0.0;

    public static final int elevatorLeftID = 0;
    public static final int elevatorRightID = 1;

    public static final double kV = 0.0;
    public static final double kA = 0.0;
  }

  public static final class RobotConstants {
    public static enum RobotStatus { REAL, SIM }
    public static RobotStatus currentStatus = RobotStatus.REAL;
  }

  public static final class IntakeConstants {
    public static final int IROLLER_MOTOR_ID = 8;
    public static final int ROLLER_MOTOR_ID = 7;
    public static final double rollerPositionConversionFactor = 1.0;
    public static final double rollerVelocityConversionFactor = 1.0;
    public static final double rollerP = 0.1;
    public static final double rollerI = 0.0;
    public static final double rollerD = 0.0;
    public static final double kVSim = 0.02;
    public static final double kASim = 0.02;  
    public static final AngularVelocity RPM = Rotations.per(Minute).of(2000);
  }
}
