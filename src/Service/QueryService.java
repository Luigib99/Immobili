package Service;
import Entity.*;
import Repository.*;

import java.util.HashMap;
import java.util.List;

public class QueryService {
    QueryRepository queryRepository = new QueryRepository();

    public HashMap<Annesso,Integer> query1()
    {
        return queryRepository.query1();
    }

    public HashMap<Immobile,Integer> query2()
    {
        return queryRepository.query2();
    }

    public HashMap<Proprietario, Integer> query3(int idScelto)
    {
        return queryRepository.query3(idScelto);
    }

    public List<Proprietario> query4()
    {
        return queryRepository.query4();
    }

    public List<Proprietario> query5()
    {
        return queryRepository.query5();
    }

    public List<Proprietario> query6()
    {
        return queryRepository.query6();
    }

    public HashMap<Proprietario, Integer> query7()
    {
        return queryRepository.query7();
    }

    public HashMap<Proprietario, Integer> query8()
    {
        return queryRepository.query8();
    }
}
