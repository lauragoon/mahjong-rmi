import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Server extends UnicastRemoteObject implements RemoteInterface
{
    protected Server() throws RemoteException { super(); }

    @Override
    public String msgTo(String name) throws RemoteException
    {
        System.err.println(name + " is trying to send a message.");
        return "Server greets " + name;
    }

    public static void main(String[] args)
    {
        try
        {
            Naming.rebind("//localhost/MyServer", new Server());            
            System.err.println("Server ready");
        }
        catch (Exception e)
        {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
