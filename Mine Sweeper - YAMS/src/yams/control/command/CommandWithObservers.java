package yams.control.command;

import java.util.List;
import yams.control.observer.Observer;

public interface CommandWithObservers extends Command {

    public List<Observer> observers();
}
