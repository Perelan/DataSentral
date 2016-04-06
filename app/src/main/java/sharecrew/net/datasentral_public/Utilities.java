package sharecrew.net.datasentral_public;

import java.util.ArrayList;

/**
 * Created by baljk on 20.01.2016.
 */
public class Utilities {
    final static String WEBSITE = "http://www.datasentral.no";


    public static ArrayList<ServiceObject> fill_object_list(){

        ArrayList<ServiceObject> mList = new ArrayList<>();

        mList.add(new ServiceObject("Timepris", "Vi tar en fast pris i timen uansett hva du trenger hjelp med.", "595", R.drawable.hour));
        mList.add(new ServiceObject("Helge Pris", "Krevende å dra ut om helgen derfor tar vi litt mer.", "749", R.drawable.helg));
        mList.add(new ServiceObject("Fjerne Virus", "Vi hjelper deg med å fjerne virus fra PC-en.", "1350", R.drawable.virus));
        mList.add(new ServiceObject("Reinstallasjon", "Vi kan hjelpe deg å reinstalere PC-en din.", "1850", R.drawable.reinstallasjon));
        mList.add(new ServiceObject("Trådløst Nettverk", "Vi setter opp nettverket for deg slik at du kan surfe uten problemer.", "595", R.drawable.wifi));
        mList.add(new ServiceObject("Web/App Utvikling", "Trengs det hjelp med å lage drømmesiden? Alt du trenger er ideen!", "300", R.drawable.webdesign));
        mList.add(new ServiceObject("Opplæring", "Sliter du med PC eller ønsker du bare litt opplæring? Vi kan også hjelpe flere!", "500", R.drawable.opplering));
        mList.add(new ServiceObject("PC Sjekk", "Vi kommer og ser på om PC-en din virker som den skal. Dette dekker ikke evt. reparasjoner.", "250", R.drawable.pcsjekk));
        mList.add(new ServiceObject("Oppsett av printer", "Vi hjelper deg å sette opp printere uten problemer!", "599", R.drawable.printer));
        mList.add(new ServiceObject("Oppsett av ny PC", "Vi setter opp PC-en din og gir deg grunnpakken vår helt gratis!", "1250", R.drawable.pc));
        mList.add(new ServiceObject("Fjernhelp", "Vi kan hjelpe deg over nett i over hele landet (og verden). Alt du trenger er nettverksforbindelse.", "625", R.drawable.fjernhjelp));
        mList.add(new ServiceObject("Firma Avtale", "Vi kan hjelpe deg over nett i over hele landet (og verden). Alt du trenger er nettverksforbindelse.", "600", R.drawable.avtale));
        mList.add(new ServiceObject("Gammel til Ny", "Vi hjelper deg med å overføre filer fra den gamle PC-en, over til den nye på null komma niks!", "595", R.drawable.gammeltilny));
        mList.add(new ServiceObject("Låne Utstyr", "Vi låner ut det meste av teknologisk utstyr. Alt fra trådløs-ruter, til printer og andre nødvendig utstyr.", "250", R.drawable.utstyr));
        mList.add(new ServiceObject("Data Håndtering", "Vi hjelper deg med å sletting unøvendig data og sikkerhetskopiering/backup av data.", "750", R.drawable.data));

        return mList;
    }
}
