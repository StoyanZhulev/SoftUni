package app.commands.group;

import app.commands.Command;
import app.mediator.AttackGroup;
import app.observer.ObservableTarget;

public class GroupTargetCommand implements Command{

    private ObservableTarget target;
    private AttackGroup group;

    public GroupTargetCommand( AttackGroup group, ObservableTarget target) {
        this.target = target;
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupTarget(this.target);
    }
}
