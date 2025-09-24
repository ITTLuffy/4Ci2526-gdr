public class App {
    public static void main(String[] args) throws Exception {
        
        Squadra team = new Squadra();

        Giocatore aragorn = new Guerriero("Aragorn", 100, 0, 80, Razza.Umano);
        Giocatore gandalf = new Mago("Gandalf", 70, 100, 20, Razza.Ent);
        Giocatore legolas = new Arciere("Legolas", 90, 0, 50, Razza.Elfo);

        team.aggiungiGiocatore(aragorn);
        team.aggiungiGiocatore(gandalf);
        team.aggiungiGiocatore(legolas);

        team.salutaTutti();

        System.out.println("Battaglia");
        Equip spada = new Equip("Anduril", 20, TipoEquip.ArmaMischia);
        aragorn.aggiungiEquip(spada);
        System.out.println("Peso inventario: " + aragorn.getPeso()); 

        // TODO
        Equip elmo = new Equip("Elmo", 5, TipoEquip.Armatura);
        Equip armor = new Equip("Armatura", 30, TipoEquip.Armatura);
        Equip arco = new Equip("Arco", 5, TipoEquip.ArmaRanged);
        legolas.aggiungiEquip(armor);
        legolas.aggiungiEquip(elmo);
        legolas.aggiungiEquip(arco);

        int danno = aragorn.attacca(legolas, 50);
        System.out.printf("Inflitti %d danni\n", danno);
        team.salutaTutti();

        int danno2 = legolas.attacca(aragorn, 50);
        System.out.printf("Inflitti %d danni\n", danno2);
        team.salutaTutti();

        int danno3 = gandalf.attacca(legolas, 100);
        System.out.printf("Inflitti %d danni\n", danno3);
        team.salutaTutti();


    }
}