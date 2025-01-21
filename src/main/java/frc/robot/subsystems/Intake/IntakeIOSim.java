package frc.robot.subsystems.Intake;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import frc.robot.Constants;

public class IntakeIOSim implements IntakeIO{

	@Override
	public void processInputs(IntakeIOInputsAutoLogged inputs) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'processInputs'");
	}

	@Override
	public void setRollerVolts(double volts) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setRollerVolts'");
	}

	@Override
	public void setRollerRPM(AngularVelocity rpm) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setRollerRPM'");
	}

	@Override
	public void setRollerPID(double kP, double kI, double kD) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'setRollerPID'");
	}
}
