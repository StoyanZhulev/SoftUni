package Pr02_Blob.models.attacks;

import Pr02_Blob.models.Blob;

public class BlobPlode extends AbstractAttack{
    @Override
    public void execute(Blob attacker, Blob target) {
        attacker.setHealth(attacker.getHealth() / 2);
        target.respond(attacker.getDamage() * 2);
    }
}
