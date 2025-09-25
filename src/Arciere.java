public class Arciere extends Giocatore{
    
    public Arciere(String nome, int hp, int mana, int peso, Razza razza) {
        super(nome, hp, mana, peso, razza);
    }

    @Override
    public int attacca(Giocatore target, int danno) {

        boolean haArma = false;

        // cerco nell'inventario se ho un arma ranged
        for (Equip equip : inventario) {
            if (equip.getTipo() == TipoEquip.ArmaRanged) {
                haArma = true;
                break;
            }
        }

        // attacco solo se ho l'arma
        if (!haArma) return 0;

        // verifico se il target ha armatura
        int armature = 0;
        for (Equip equip : target.getInventario()) {
            if (equip.getTipo() == TipoEquip.Armatura) {
                armature++;
            }
        }

        // modifico i puntivita del target
        int dannoFinale = danno / (armature + 1);
        target.setHp(target.getHp() - dannoFinale); 
        
        return dannoFinale;
    }

    @Override
    public void ricaricaMana() {
        
    }
    
}
