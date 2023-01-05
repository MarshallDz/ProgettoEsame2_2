package progetto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Progetto {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader((new FileReader("/Users/michelemarzioni/Desktop/ProgettoEsame/Esempi_traccia_A/es_input_1.txt")));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }
}