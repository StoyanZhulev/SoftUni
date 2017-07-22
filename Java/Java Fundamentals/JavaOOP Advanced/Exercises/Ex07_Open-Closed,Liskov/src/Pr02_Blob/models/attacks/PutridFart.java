package Pr02_Blob.models.attacks;

import Pr02_Blob.models.Blob;

public class PutridFart extends AbstractAttack {

    public void execute(Blob source, Blob target) {
        target.respond(source.getDamage());
    }
}
