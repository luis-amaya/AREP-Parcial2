package co.edu.escuelaing.parcial2;

import static spark.Spark.*;

import org.json.JSONObject;

import spark.Request;
import spark.Response;

public class EjerciciosDeDiseno {

    private static Calculadora cal;

    public static void main(String[] args) {
        cal = Calculadora.initCalculadora();
        staticFiles.location("/public");
        port(getPort());
        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/atan", "application/json", (req, res) -> operations(req, res));

    }

    public static JSONObject operations(Request req, Response res) {
        JSONObject json;

        return null;
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
