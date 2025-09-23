import java.util.ArrayList;

public abstract class Giocatore {

    protected String nome;
    protected int hp;
    protected final int HP_MAX, MANA_MAX, PESO_MAX;
    protected int mana;
    protected int peso;
    protected Razza razza;
    protected ArrayList<Equip> inventario;

    public Giocatore(String nome, int hp, int mana, int peso, Razza razza) {
        this.nome = nome;
        this.hp = this.HP_MAX = hp;
        this.mana = this.MANA_MAX = mana;
        this.peso = 0; 
        this.PESO_MAX = peso;
        this.razza = razza;

        this.inventario = new ArrayList<>(); // istanziamo e inizializziamo
    }

    public int attaccaMischia(Giocatore target, int danno) {

        boolean haArma = false;

        // cerco nell'inventario se ho almeno un'arma da mischia
        for (Equip e : inventario) {

            if (e.getTipo() == TipoEquip.ArmaMischia) {
                haArma = true;
                break;
            }
        }

        // controllo l'istanza del mio oggetto e attacco solo se ho l'arma
        if (!(this instanceof Guerriero) || !haArma) {
            return 0;
        }

        // verifico se il target ha armature e le conto
        int armature = 0;
        for (Equip e : target.getInventario()) {
            
            if (e.getTipo() == TipoEquip.Armatura)
                armature++;
        }

        // modifico i puntivita del target
        int dannoFinale = danno / (armature + 1);
        target.setHp(target.getHp() - dannoFinale); 
        return dannoFinale;
    }

    public int attaccaRanged(Giocatore target, int danno) {
        
        boolean haArma = false;

        // cerco nell'inventario se ho un arma ranged
        for (Equip equip : inventario) {
            if (equip.getTipo() == TipoEquip.ArmaRanged) {
                haArma = true;
                break;
            }
        }

        // controllo l'instanza del mio oggetto e attacco solo se ho l'arma
        if (!(this instanceof Arciere) || !haArma) {
            return 0;
        }

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

    public int attaccaMago(Giocatore target, int danno) {
        
        // controllo l'instanza del mio oggetto e attacco solo se ho mana
        if (!(this instanceof Mago) || mana < danno) {
            return 0;
        }

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
        mana = mana - danno;

        if(target.isMorto()) {
            this.ricaricaMana();
        }
        
        return dannoFinale;

    }

    public boolean ricaricaMana() {
        if(!(this instanceof Mago)){
            return false;
        }

        this.mana += MANA_MAX;
        return true;
    }

    private void aggiornaPeso() {
        peso = 0;
        for(Equip equip : inventario) {
            peso += equip.getPeso();
        }
    }

    public void svuotaInventario() {
        inventario.clear();
        aggiornaPeso();
    }

    public boolean isTroppoCarico() {
        return peso > PESO_MAX;
    }

    public boolean aggiungiEquip(Equip nuovo) {
        if(nuovo.getPeso() + peso > PESO_MAX) return false;
        
        inventario.add(nuovo);
        aggiornaPeso();
        return true;
    }

    public boolean isMorto() {
        return hp <= 0;
    }

    public void saluta(){
        System.out.println("Ciao, mi chiamo " + nome + " e sono un " + razza);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp >= HP_MAX) {
            this.hp = HP_MAX;
        } else {
            this.hp = hp;
        }
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public ArrayList<Equip> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Equip> inventario) {
        this.inventario = inventario;
    }

    
    
}
