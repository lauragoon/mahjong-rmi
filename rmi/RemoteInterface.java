import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {

    public String msgTo(String name) throws RemoteException;

}
