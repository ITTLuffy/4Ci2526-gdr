public class Medico extends Giocatore {
    private final int MANA_CURA = 20;


    public Medico(String nome, int hp, int mana, int peso, Razza razza) {
        super(nome, hp, mana, peso, razza);

    }

    @Override
    public int attacca(Giocatore target, int cura) {
        
        if (mana - MANA_CURA >= 0 && target.getHp() + cura > target.HP_MAX) {
            mana -= MANA_CURA;

            target.setHp(target.getHp() + cura);

            return cura;
        }

        return 0;

    }

    @Override
    public void ricaricaMana() {

        mana = MANA_MAX;

    }

    public boolean rianima(Giocatore target) {
        if(!target.isMorto()) return false;

        target.setHp(target.HP_MAX / 4);
        return true;
    }

    @Override
    public boolean aggiungiEquip(Equip nuovo) {

        // il medico non deve portare armi
        if(nuovo.getTipo() == TipoEquip.ArmaMischia || nuovo.getTipo() == TipoEquip.ArmaRanged) return false;

        return super.aggiungiEquip(nuovo);
    }

}
