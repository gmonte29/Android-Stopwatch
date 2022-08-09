package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelSource;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.TickListener;

/**
 * The state machine for the state-based dynamic model of the timer.
 * This interface is part of the State pattern.
 *
 * @author Team 1
 */
public interface TimerStateMachine extends TimerUIListener, TickListener, TimerModelSource, TimerSMStateView { }
