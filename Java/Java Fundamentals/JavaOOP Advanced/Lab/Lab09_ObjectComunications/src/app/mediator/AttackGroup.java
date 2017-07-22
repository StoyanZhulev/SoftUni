package app.mediator;


import app.models.Attacker;
import app.observer.ObservableTarget;

public interface AttackGroup {
    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();
}
