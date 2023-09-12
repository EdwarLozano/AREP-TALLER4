package edu.eci.arep;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.eci.arep.Spark.*;
import edu.eci.arep.Services.*;
import edu.eci.arep.SpringBoot.Component;


public class App {
    static HttpServer httpServer = HttpServer.getInstance();
    static Map<String,Service> services = new HashMap();
    public static void main(String[] args) throws IOException {
        Spark.get("/apps",(req,res) -> {
            Service service = new WebService();
            return service;
        });
        Spark.get("/apps/search/",(req,res) -> {
            Service service = new SearchService();
            return service;
        });
        httpServer.run(args,services);
    }
}