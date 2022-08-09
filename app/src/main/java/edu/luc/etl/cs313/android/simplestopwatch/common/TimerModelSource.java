package edu.luc.etl.cs313.android.simplestopwatch.common;

/**
 * A source of UI update events for the timer.
 * This interface is typically implemented by the model.
 *
 * @author Team 1
 */
public interface TimerModelSource {
    void setModelListener(TimerModelListener listener);
}
