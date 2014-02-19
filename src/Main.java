import jsonparserapi.JSONObject;
import jsonparserapi.JSONTokener;
import models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String args[]) throws IOException {

        User user = new User();
        user.getUser(22);
        user.deleteUser();
    }
}
