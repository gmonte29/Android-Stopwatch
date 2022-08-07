package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.android.TimerAdapter;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the state machine for the stopwatch.
 *
 * @author laufer
 */
public class DefaultTimerStateMachine implements TimerStateMachine {

    public DefaultTimerStateMachine(final TimeModel timeModel, final ClockModel clockModel) {
        this.timeModel = timeModel;
        this.clockModel = clockModel;
    }

    private final TimeModel timeModel;

    private final ClockModel clockModel;

    /**
     * The internal state of this adapter component. Required for the State pattern.
     */
    private TimerState state;

    protected void setState(final TimerState state) {
        this.state = state;
        listener.onStateUpdate(state.getId());
    }

    private TimerModelListener listener;

    @Override
    public void setModelListener(final TimerModelListener listener) {
        this.listener = listener;
    }

    // forward event uiUpdateListener methods to the current state
    // these must be synchronized because events can come from the
    // UI thread or the timer thread
    @Override public synchronized void onStartStop() { state.onStartStop(); }
    //@Override public synchronized void onLapReset()  { state.onLapReset(); }
    @Override public synchronized void onTick()      { state.onTick(); }

    @Override public void updateUIRuntime() { listener.onTimeUpdate(timeModel.getRuntime()); }


    //@Override public void updateUILaptime() { listener.onTimeUpdate(timeModel.getLaptime()); }

    // known states
    private final TimerState STOPPED     = new StoppedState(this);
    private final TimerState RUNNING     = new RunningState(this);

    //methods below renamed globally
    private final TimerState INCREMENT = new IncrementState(this);
    private final TimerState ALARM = new AlarmState(this);

    // transitions
    @Override public void toRunningState()    { setState(RUNNING); }
    @Override public void toStoppedState()    { setState(STOPPED); }

    //methods below renamed globally
    @Override public void toIncrementState() { setState(INCREMENT); }
    @Override public void toAlarmState() { setState(ALARM); }

    // actions
    @Override public void actionInit()       { toStoppedState(); actionReset(); }
    @Override public void actionReset()      { timeModel.resetRuntime(); actionUpdateView(); }
    @Override public void actionStart()      { clockModel.start(); }
    @Override public void actionStop()       { clockModel.stop(); }
    //@Override public void actionLap()        { timeModel.setLaptime(); }
    @Override public void actionInc()        { timeModel.incRunTime(); actionUpdateView(); }
    @Override public void actionDec()        { timeModel.decRuntime(); actionUpdateView(); }
    @Override public void actionUpdateView() { state.updateView(); }
    @Override  public int actionReturn()     {return timeModel.getRuntime();}

    @Override public void playAlarm()         { ((TimerAdapter)listener).playDefaultNotification();}


}
