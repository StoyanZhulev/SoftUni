package Pr02_Blob.models.attacks;

import Pr02_Blob.interfaces.Attack;
import Pr02_Blob.models.Blob;

public abstract class AbstractAttack implements Attack {
    public abstract void execute(Blob attacker, Blob target);
}
