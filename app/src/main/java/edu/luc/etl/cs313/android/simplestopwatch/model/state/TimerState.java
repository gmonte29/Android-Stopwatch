package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.TickListener;

/**
 * A state in a state machine. This interface is part of the State pattern.
 *
 * @author laufer
 */
interface TimerState extends TimerUIListener, TickListener {
    void updateView();
    int getId();
}
