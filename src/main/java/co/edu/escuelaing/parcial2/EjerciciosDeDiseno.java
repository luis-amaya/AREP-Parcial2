package co.edu.escuelaing.parcial2;

import static spark.Spark.*;

import java.util.List;

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

        get("/atan", "application/json", (req, res) -> {
            res.type("application/json");
            return operations("atan", req, res);
        });
        get("/sin", "application/json", (req, res) -> {
            res.type("application/json");
            return operations("sin", req, res);
        });

    }

    public static JSONObject operations(String operation, Request req, Response res) {
        JSONObject json;
        Double value = Double.parseDouble(req.queryParams("value"));
        Double result = 0.0;
        if (operation.equals("atan")) {
            result = cal.arTan(value);
            json = getJSON(value, result, operation);
        } else {
            result = cal.sin(value);
            json = getJSON(value, result, operation);
        }
        return json;
    }

    private static JSONObject getJSON(Double value, Double result, String operation) {
        JSONObject json = new JSONObject();
        json.put("Operation", operation);
        json.put("Input", value);
        json.put("Output", result);
        return json;
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
