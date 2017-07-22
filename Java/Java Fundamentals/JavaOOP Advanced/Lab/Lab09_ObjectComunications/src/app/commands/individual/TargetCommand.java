package app.commands.individual;

import app.commands.Command;
import app.models.Attacker;
import app.observer.ObservableTarget;

public class TargetCommand implements Command {
    private Attacker attacker;
    private ObservableTarget target;

    public TargetCommand(Attacker attacker, ObservableTarget target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(target);
    }
}
