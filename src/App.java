public class App {
    public static void main(String[] args) throws Exception {

        Squadra team = new Squadra();

        Giocatore aragorn = new Guerriero("Aragorn", 100, 0, 90, Razza.Umano);
        Giocatore gandalf = new Mago("Gandalf", 70, 100, 20, Razza.Transformer);
        Giocatore legolas = new Arciere("Legolas", 90, 0, 50, Razza.Elfo);

        team.aggiungiGiocatore(aragorn);
        team.aggiungiGiocatore(gandalf);
        team.aggiungiGiocatore(legolas);

        team.salutaTutti();

        Equip spada = new Equip("Anduril", 20, TipoEquip.ArmaMischia);
        aragorn.aggiungiEquip(spada);
        System.out.println("Peso inventario: " + aragorn.getPeso());
        

        // TODO
        Equip elmo = new Equip("Elmo", 5, TipoEquip.Armatura);
        Equip armor = new Equip("Armatura", 30, TipoEquip.Armatura);
        
        legolas.aggiungiEquip(armor);

        aragorn.attaccaMischia(legolas, 90);
        team.salutaTutti();



    }
}
