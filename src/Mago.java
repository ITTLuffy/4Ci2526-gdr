public class Mago extends Giocatore {
    private final int MANA_ATT = 20;

    public Mago(String nome, int hp, int mana, int peso, Razza razza) {
        super(nome, hp, mana, peso, razza);

    }

    @Override
    public int attacca(Giocatore target, int danno) {

        // verifico se il target ha armatura
        int armature = 0;
        for (Equip equip : target.getInventario()) {
            if (equip.getTipo() == TipoEquip.Armatura) {
                armature++;
            }
        }

        if (mana - MANA_ATT >= 0) {
            mana -= MANA_ATT;

            int multi = 1;
            if (target instanceof Guerriero || target instanceof Arciere) {
                multi = 2;
            }

            // modifico i puntivita del target
            int dannoFinale = multi * danno / (armature + 1);
            target.setHp(target.getHp() - dannoFinale);
            mana = mana - danno;

            if (target.isMorto()) {
                ricaricaMana();
            }
        
            return dannoFinale;
        }

        return 0;
    }

    private void ricaricaMana() {

        this.mana = MANA_MAX;

    }

}