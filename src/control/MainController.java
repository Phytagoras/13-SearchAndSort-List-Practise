package control;

import model.List;
import model.Person;

public class MainController {

    private final List<Person> allPersons;
    private final String[] names = {"Alsbach", "Bachmann", "Cyrus", "Davidoff", "Eregon", "Füller", "Giesehau", "Halidsch", "Irimoff", "Zylla", "Yilderim", "Lupp", "Schein", "Xenomo", "Iwan", "Ali", "Kötter", "Kleinhans", "Diablo", "Overwatch", "Starcraft", "Warcraft", "Minecraft", "Krunker", "Command", "And", "Conquer", "Path", "Exile", "Valheim"};

    public MainController(int amount){
        allPersons = new List<>();
        for ( int i = 0; i < amount; i++ ) {
            allPersons.append(createPerson());
        }
    }

    private Person createPerson(){
        Person p = new Person(getRandomName());
        return p;
    }

    public String getRandomName(){
        return names[ (int) ( Math.random() * names.length ) ];
    }

    public String showList(){
        String output = "Ausgabe: ";
        allPersons.toFirst();
        while (allPersons.hasAccess()) {
            output = output + allPersons.getContent().getName() + " (" + allPersons.getContent().getBirthdate() + "), ";
            allPersons.next();
        }
        return output;
    }


    /**
     * Schreibe einen Algorithmus zum Suchen einer Person innerhalb einer Liste. Falls die Person gefunden wurde, gib ihren Namen samt Geburtsdatum aus.
     *
     * @param name
     * @return
     */
    public String searchList(String name){
        String output = "Nicht gefunden.";
        allPersons.toFirst();
        while (allPersons.hasAccess()) {
            if ( allPersons.getContent().getName().equalsIgnoreCase(name) ) {
                output = "Name: " + allPersons.getContent().getName() + "  Geburtsdatum: " + allPersons.getContent().getBirthdate();
                return output;
            }
            allPersons.next();
        }
        output = "Nichts gefunden";
        return output;
    }


    /**
     * Stortiere die Liste nach Namen (nicht nach Geburtsdatum!). Entscheide dich hierzu für einen Sortieralgorithmus.
     * Gib an, ob deine Umsetzung stabil ist und ob sie in-place ist.
     */
    public void sortList(){
        List<Person> help = new List<>();
        help.concat(allPersons);
        help.toFirst();
        while (help.hasAccess()) {
            allPersons.toFirst();
            while (allPersons.hasAccess() && help.getContent().getName().compareTo(allPersons.getContent().getName()) >= 0) {
                allPersons.next();
            }
            if ( allPersons.hasAccess() ) {
                allPersons.insert(help.getContent());
            } else {
                allPersons.append(help.getContent());
            }
            help.next();
        }


    }


}
