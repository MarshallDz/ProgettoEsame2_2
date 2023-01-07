package progetto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Progetto {
    public static void main(String[] args) throws IOException {

        //TASK 1
        ArrayList<Regalo> regali = new ArrayList<>();
        ArrayList<Pianeta> pianeti = new ArrayList<>();
        ArrayList<Citta> arrCitta = new ArrayList<>();
        int regaliTotali = 0;
        int nCitta = 0;
        Collegamento c;
        ArrayList<String> destinazioni = new ArrayList<>();
        ArrayList<Integer> pesi = new ArrayList<>();
        char primoCarattere;
        char secondoCarattere;

        BufferedReader reader = new BufferedReader((new FileReader("Esempi_traccia_A/es_input_1.txt")));
        String line;
        while((line = reader.readLine()) != null){
            String[] splittedArr = line.split(" |\\#|\\,");
            primoCarattere = splittedArr[0].charAt(0);

            if(primoCarattere == 'r'){
                Regalo regalo = new Regalo(splittedArr[0], Integer.parseInt(splittedArr[1]), splittedArr[2]);
                regali.add(regalo);
            }

            else if(primoCarattere == 'p'){
                Pianeta pianeta = new Pianeta(splittedArr[0], Integer.parseInt(splittedArr[1]));
                nCitta += pianeta.getnCitta();
                pianeti.add(pianeta);

            }
            else if(primoCarattere == 'c'){
                secondoCarattere = splittedArr[1].charAt(0);
                if(secondoCarattere == 'p') {
                    Citta citta = new Citta(splittedArr[0], splittedArr[1], Integer.parseInt(splittedArr[2]));
                    arrCitta.add(citta);
                    for (int j = 3; j < splittedArr.length; j++) {
                        if (j % 2 == 1){
                            destinazioni.add(splittedArr[j]);
                            if (splittedArr[j].charAt(0) != 'c'){
                                pesi.add(0);
                            }
                        }
                        else pesi.add(Integer.parseInt(splittedArr[j]));
                    }
                    for(int i = 0; i < pesi.size(); i++){
                        c = new Collegamento(destinazioni.get(i), pesi.get(i));
                        citta.aggiungiArco(c);
                    }
                    destinazioni.clear();
                    pesi.clear();
                }
            }
        }
        reader.close();
        for(Citta o: arrCitta){
            o.stampaArchi();
        }
    }
}
