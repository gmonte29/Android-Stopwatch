package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

/**
 * A source of onTick events for the timer.
 * This interface is typically implemented by the model.
 *
 * @author Team 1
 */
public interface TickSource {
    void setTickListener(TickListener listener);
}
