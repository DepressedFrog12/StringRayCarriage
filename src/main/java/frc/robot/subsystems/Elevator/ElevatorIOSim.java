package frc.robot.subsystems.Elevator;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.ElevatorSim;
import frc.robot.Constants.ElevatorConstants;

public class ElevatorIOSim {
    public double kV = ElevatorConstants.kV;
    public double kA = ElevatorConstants.kA;
    DCMotor gearbox;
    double[] heights = {0.0, 2.0};
    ElevatorSim sim;

    public static class ElevatorInputs {

    }
}
