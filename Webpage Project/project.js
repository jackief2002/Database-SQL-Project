import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.util.Map;
import java.sql.*;
//javac -cp sqlite-jdbc-3.23.1.jar; DatabaseExample.java

public class Project {

    public static void main(String[] args) throws IOException {
		
		Database  db =  new  Database("jdbc:sqlite:JF.db" );        
		
		int port = 8500;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
		server.createContext("/customers", new RouteHandler(db, "SELECT * from customers;"));
        server.start();		    
    }    

}
