import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.util.Map;
import java.sql.*;
//javac -cp sqlite-jdbc-3.23.1.jar; project.java

public class project {

    public static void main(String[] args) throws IOException {
		
		Database  db =  new  Database("jdbc:sqlite:JF.db" );        
		int port = 8500;
		HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        server.createContext("/books", new RouteHandler(db, "SELECT * FROM bookbase;"));
        server.createContext("/movies", new RouteHandler(db, "SELECT * FROM moviebase;"));        
        server.createContext("/umathurman", new RouteHandler(db, "select * from moviebase where actors like '%Thurman%';"));
        server.createContext("/fantasy", new RouteHandler(db, "select * from moviebase where genre like '%Fantasy%';"));

        server.start();		    
        
    }    

}
