// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


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

  public static final class RobotConstants {
    public static enum RobotStatus { REAL, SIM }
    public static RobotStatus currentStatus = RobotStatus.REAL;
  }

  public static final class CarriageConstants {
    public static final int CARRIAGE_MOTOR_ID = 21;
    public static final double carriagePositionConversionFactor = 1.0;
    public static final double carriageVelocityConversionFactor = 1.0;
    public static final double carriageP = 0.1;
    public static final double carriageI = 0.0;
    public static final double carriageD = 0.0;
    public static final double kVSim = 0.02;
    public static final double kASim = 0.02;  
    public static final double RPM = 0.35;
  }
}
