package ie.atu.sw;

/* MessageClient is the client of our remote message service. The Naming.lookup() call
 * is a request to a remote registry for an object with a human-readable name. The object 
 * returned is really an instance of a proxy stub, but the client thinks it is dealing with 
 * the real remote object. The lookup() method returns a type of java.lang.Object which we need
 * to cast to the interface type. The statement:
 * 
 *			Message message = ms.getMessage();
 * 		
 * is the actual remote method invocation. Notice how there no special coding required
 * to deal with the remote invocation. This is an example of Local/Remote Transparency.
 *
 *
 * Note also that there is no reference to any server-side object type except for the remote
 * interface. The client is loosely-coupled with the remote object. If we don't like our
 * implementation of the remote object, we can substitute it with a different class that
 * implements MessageService without having to recompile the client.
 */
import java.rmi.Naming;
public class MessageClient {
	public static void main(String[] args) throws Exception{
		
		//Ask the registry running on 10.2.2.65 and listening in port 1099 for the instannce of
		//the MessageService object that is bound to the RMI registry with the name ATUMessageService.
		MessageService ms = (MessageService) Naming.lookup("rmi://127.0.0.1:1099/ATUMessageService");
		
		//Make the remote method invocation. This results in the Message object being transferred
		//to us over the network in serialized form. 
		Message message = ms.getMessage();
		
		//Print out the message from the message object.
		System.out.println(message.message());
	}
}
