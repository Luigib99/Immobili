package Controller;
import Service.QueryService;
import Entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class QueryController {
    Scanner scanner = new Scanner(System.in);
    QueryService queryService = new QueryService();

    public void query1()
    {
        HashMap<Annesso,Integer> listaAnnessi=queryService.query1();
        for(Annesso annesso:listaAnnessi.keySet())
        {
            System.out.println("IL NUMERO DI BOX PRESENTI E': " + listaAnnessi.get(annesso));
        }
    }

    public void query2()
    {
        HashMap<Immobile,Integer> listaImmobili=queryService.query2();
        for(Immobile immobile:listaImmobili.keySet())
        {
            System.out.println("IL NUMERO DI VILLE CON GIARDINO E': " + listaImmobili.get(immobile));
        }
    }

    public void query3()
    {
        System.out.println("SCEGLI L'ID DEL PROPRIETARIO DI CUI VEDERE LA SUPERFICIE TOTALE");
        int idScelto =scanner.nextInt();
        HashMap<Proprietario,Integer> listaProprietari=queryService.query3(idScelto);
        for(Proprietario proprietario:listaProprietari.keySet())
        {
            System.out.println("LA SUPERFICIE TOTALE DI " +proprietario.getNome() + " "+ proprietario.getCognome() +" E': " + listaProprietari.get(proprietario) + " METRI ");
        }
    }

    public void query4()
    {
        System.out.println("I PROPRIETARI CON LA VILLA SONO: ");
        List<Proprietario> listaProprietari = queryService.query4();
        for (Proprietario proprietario : listaProprietari)
        {
            System.out.println(proprietario.getNome() + " " + proprietario.getCognome());
        }
    }

    public void query5()
    {
        System.out.println("I PROPRIETARI CON APPARTAMENTO CON BOX SONO: ");
        List<Proprietario> listaProprietari = queryService.query5();
        for (Proprietario proprietario : listaProprietari)
        {
            System.out.println(proprietario.getNome() + " " + proprietario.getCognome());
        }
    }

    public void query6()
    {
        System.out.println("I PROPRIETARI CON IMMOBILI DI DOPO IL 1996 SONO: ");
        List<Proprietario> listaProprietari = queryService.query6();
        for (int i = 0; i < listaProprietari.size(); i++)
        {
            Proprietario proprietario = listaProprietari.get(i);
            List<Immobile> listaImmobili = proprietario.getListaImmobili();
            Immobile immobile = listaImmobili.get(0);
            System.out.println(proprietario.getNome() + " " + proprietario.getCognome() + " " + immobile.getAnno());
        }
    }

    public void query7()
    {
        System.out.println("I PROPRIETARI DI APPARTAMENTI CON VANI DISPONIBILI SONO: ");
        HashMap <Proprietario,Integer> listaProprietari=queryService.query7();
        for(Proprietario proprietario:listaProprietari.keySet())
        {
            System.out.println(proprietario.getNome() + " " + proprietario.getCognome() + " CON "+ listaProprietari.get(proprietario)+ " VANI");
        }
    }

    public void query8()
    {
        System.out.println("I PROPRIETARI LA CUI SOMMA DI MQ SUPERIORE A 400MQ SONO:");
        HashMap<Proprietario,Integer> listaProprietari=queryService.query8();
        for(Proprietario proprietario:listaProprietari.keySet())
        {
            System.out.println(proprietario.getNome() + " " + proprietario.getCognome() + " " + listaProprietari.get(proprietario)+ " MQ");
        }
    }
}
