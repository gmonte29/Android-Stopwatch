package edu.luc.etl.cs313.android.simplestopwatch.model;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.DefaultClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.DefaultTimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.TimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.DefaultTimeModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the model facade.
 *
 * @author laufer
 */
public class ConcreteTimerModelFacade implements TimerModelFacade {

    private final TimerStateMachine stateMachine;

    private final ClockModel clockModel;

    private final TimeModel timeModel;

    public ConcreteTimerModelFacade() {
        timeModel = new DefaultTimeModel();
        clockModel = new DefaultClockModel();
        stateMachine = new DefaultTimerStateMachine(timeModel, clockModel);
        clockModel.setTickListener(stateMachine);
    }

    @Override
    public void start() {
        stateMachine.actionInit();
    }

    @Override
    public void setModelListener(final TimerModelListener listener) {
        stateMachine.setModelListener(listener);
    }

    @Override
    public void onMultiButton() {
        stateMachine.onMultiButton();
    }


}
