package frc.robot.subsystems.Elevator;
import org.littletonrobotics.junction.AutoLog;
import frc.robot.Constants;

public interface ElevatorIO {
    public static double elevatorRightID = Constants.ElevatorConstants.elevatorRightID;
    public static double elevatorLeftID = Constants.ElevatorConstants.elevatorLeftID;

    public abstract void setVolts();
    public abstract void updateInputs();

    @AutoLog
    public static class ElevatorInputs {
        public double elevatorRightVelocity = 0;
        public double elevatorLeftVelocity = 0;

        public double elevatorRightDistance = 0;
        public double elevatorLeftDistance = 0;

        public double elevatorRightAmps = 0;
        public double elevatorLeftAmps = 0;
    }
}
