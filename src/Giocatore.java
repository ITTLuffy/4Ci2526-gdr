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
        this.peso = this.PESO_MAX = peso;
        this.razza = razza;

        this.inventario = new ArrayList<>(); // istanziamo e inizializziamo
    }

    public void attaccaMischia(Giocatore target, int danno) {

        boolean haArma = false;

        // cerco nell'inventario se ho un arma da mischia
        for (Equip equip : inventario) {
            if (equip.getTipo() == TipoEquip.ArmaMischia) {
                haArma = true;
                break;
            }
        }

        // controllo l'instanza del mio oggetto e attacco solo se ho l'arma
        if (!(this instanceof Guerriero) || !haArma) return;
        

        // veriico se il target ha armatura
        int armature = 0;
        for (Equip equip : target.getInventario()) {
            if (equip.getTipo() == TipoEquip.Armatura) {
                armature++;
            }
        }

        // modifico i punti vita del target
        target.setHp(target.getHp() - danno / (armature + 1));

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
