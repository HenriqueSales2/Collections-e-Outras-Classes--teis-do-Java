package APIStreamsAndGenerics.Generics;

import APIStreamsAndGenerics.Generics.dao.ClientDAO;
import APIStreamsAndGenerics.Generics.dao.GenericDAO;
import APIStreamsAndGenerics.Generics.dao.UserDAO;
import APIStreamsAndGenerics.Generics.domain.ClientDomain;
import APIStreamsAndGenerics.Generics.domain.UserDomain;

public class Main {

    private final static GenericDAO<Integer, UserDomain> userDao = new UserDAO();
    private final static GenericDAO<String, ClientDomain> clientDao = new ClientDAO();

    public static void main(String[] args) {


        System.out.println("===UserDAO===");
        var user = new UserDomain(1,"Henrique", 18);
        var user2 = new UserDomain(2, "Ana", 33);

        System.out.println(userDao.count());
        System.out.println(userDao.save(1,user));
        System.out.println(userDao.findAll());
        System.out.println(userDao.count());
        System.out.println(userDao.save(2,user2));
        System.out.println(userDao.count());
        System.out.println(userDao.findAll());
        System.out.println(userDao.delete(user2));
        System.out.println(userDao.findAll());
        System.out.println(userDao.findById(1));
        System.out.println("===UserDAO.fim===");
        System.out.println(" ");

        System.out.println("===ClientDAO===");
        var client = new ClientDomain("3","Helena", 23);
        var client2 = new ClientDomain("4", "Luiz", 45);
        var client3 = new ClientDomain("5", "Jonathan", 24);
        var client4= new ClientDomain("6", "Kate", 34);


        System.out.println(clientDao.count());
        System.out.println(clientDao.save(1,client));
        System.out.println(clientDao.findAll());
        System.out.println(clientDao.count());
        System.out.println(clientDao.save(2,client2));
        System.out.println(clientDao.count());
        System.out.println(clientDao.findAll());
        System.out.println(clientDao.delete(client));
        System.out.println(clientDao.findAll());
        System.out.println(clientDao.findById(String.valueOf(4)));
        System.out.println(clientDao.save(3, new ClientDomain("7", "Denis", 65), new ClientDomain("8", "Debra", 32))); // está funcionando o save passando vários argumentos, só que desta vez passando manualmente
        System.out.println(clientDao.findAll());
        System.out.println(clientDao.save(4, client3, client4)); // está funcionando o save passando vários argumentos, só que desta vez passando variavéis
        System.out.println(clientDao.findById("5"));
        System.out.println("===ClientDAO.fim===");
    }
}
