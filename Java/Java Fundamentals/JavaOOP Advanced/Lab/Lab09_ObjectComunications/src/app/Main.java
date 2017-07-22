package app;

import app.commands.Command;
import app.commands.CommandExecutor;
import app.commands.Executor;
import app.commands.group.GroupAttackCommand;
import app.commands.group.GroupTargetCommand;
import app.commands.individual.TargetCommand;
import app.logger.CombatLogger;
import app.logger.EventLogger;
import app.logger.Handler;
import app.logger.LogType;
import app.mediator.AttackGroup;
import app.mediator.Group;
import app.models.Dragon;
import app.models.Warrior;
import app.observer.ObservableTarget;

public class Main {
    public static void main(String[] args) {
        Handler combatLogger = new CombatLogger();
        Handler eventLogger= new EventLogger();

        combatLogger.setSuccessor(eventLogger);

        combatLogger.handle(LogType.EVENT, "attack");

        AttackGroup group = new Group();
        Warrior waarrior = new Warrior("Gosho", 10, combatLogger);
        ObservableTarget dragon = new Dragon("Miro", 10, 100, combatLogger);

        group.addMember(waarrior);
        group.addMember(new Warrior("Stamat", 20, combatLogger));

        Executor commandEx = new CommandExecutor();

        Command command = new TargetCommand(waarrior, dragon);
        Command groupCommand = new GroupTargetCommand(group, dragon);
        Command groupAttack = new GroupAttackCommand(group);
        commandEx.executeCommand(groupCommand);
        commandEx.executeCommand(groupAttack);
    }
}