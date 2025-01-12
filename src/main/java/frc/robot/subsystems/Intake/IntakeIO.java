package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;

public interface IntakeIO {

    @AutoLog
    public class IntakeIOInputs {
        public Rotation2d pivotPosition = new Rotation2d();
        public Rotation2d pivotTargetPosition = new Rotation2d();

        // Rotation in Radians per second
        public double pivotRPS = 0.0;
        public double pivorAppliedVolts = 0.0;
        public double pivotCurrentAmps = 0.0;

        //Tempperature in Degrees C
        public double pivotTemp = 0.0;

        public double rollerRPM = 0.0;
        public double rollerTargetRPM = 0.0;

        public double rollerAppliedVolts = 0.0;
        public double rollerCurrentAmps = 0.0;

        //Tempperature in Degrees C
        public double rollerTemp = 0.0;
    }

    public abstract void processInputs(final IntakeIOInputs inputs);

    public abstract void updateinputs(final IntakeIOInputs inputs);
}
