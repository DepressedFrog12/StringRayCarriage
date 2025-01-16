package frc.robot.subsystems.Intake;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.units.measure.AngularVelocity;

public interface IntakeIO {

    // iRoller is the roller that will have negative RPM (inverted roller)
    @AutoLog
    public class IntakeIOInputs {
        public double rollerRPM = 0.0;
        public double iRollerRPM = 0.0;

        public double targetRPM = 0.0;

        public double rollerAmps = 0.0;

        public double rollersVolts = 0.0;

        public double rollerkP = 0.0;
        public double rollerkI = 0.0;
        public double rollerkD = 0.0;

        public double rollerTemp = 0.0;
        public double iRollerTemp = 0.0;

    }

    public abstract void processInputs(final IntakeIOInputsAutoLogged inputs);

    public abstract void setRollerVolts(double volts);

    public abstract void setRollerRPM(AngularVelocity rpm, SimpleMotorFeedforward feedforward);

    public abstract void setRollerPID(double kP, double kI, double kD);
}
