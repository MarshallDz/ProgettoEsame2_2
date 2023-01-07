package progetto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Progetto {
    public static void main(String[] args) throws IOException {
        ArrayList<Regalo> regali = new ArrayList<>();
        ArrayList<String> regaliOrdinati = new ArrayList<>();
        ArrayList<Pianeta> pianeti = new ArrayList<>();
        ArrayList<Citta> arrCitta = new ArrayList<>();
        int regaliTotali = 0;
        int arte = 0;
        int sport = 0;
        int elettronica = 0;
        int regaliPianeta = 0;
        int costoPianeta = 0;
        Pianeta maxPianeta = new Pianeta("" , 0);
        Pianeta costoRegaliPianeta = new Pianeta(" ", 0);
        Collegamento c;
        ArrayList<String> destinazioni = new ArrayList<>();
        ArrayList<Integer> pesi = new ArrayList<>();
        char primoCarattere;
        char secondoCarattere;
        //lettura file
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
                else{
                    regaliTotali += (splittedArr.length) - 2;

                    for(Pianeta p: pianeti){
                        //controllo se la citta e' nell'array delle citta
                        for(Citta c1 : arrCitta){
                            if(c1.getNomeCitta().equals(splittedArr[0])){
                                if(c1.getPianetaO().equals(p.getNomePianeta())){
                                    for (int i = 2; i < splittedArr.length; i++) {
                                        for(Regalo r : regali){
                                            if(r.getNomeRegalo().equals(splittedArr[i]))
                                                costoPianeta += r.getCosto();
                                        }
                                    }
                                    System.out.println(costoPianeta);
                                }
                            }
                        }
                        p.setCostoRegali(costoPianeta);
                        if(p.getCostoRegali() > costoRegaliPianeta.getCostoRegali()) costoRegaliPianeta = p;
                    }

                    for (int i = 2; i < splittedArr.length; i++) {
                        if(!regaliOrdinati.contains(splittedArr[i])) {
                            regaliOrdinati.add(splittedArr[i]);
                        }
                        for(Regalo r : regali){
                            if(r.getNomeRegalo().equals(splittedArr[i])){
                                switch (r.getTipo()){
                                    case "arte":
                                        arte++;
                                        break;
                                    case "elettronica":
                                        elettronica++;
                                        break;
                                    case "sport":
                                        sport++;
                                        break;
                                }
                            }
                        }
                    }
                    for(Pianeta p: pianeti){
                        for (Citta c1: arrCitta) {
                            if(c1.getPianetaO().equals(p.getNomePianeta())){
                                regaliPianeta += (splittedArr.length) - 2;
                            }
                        }
                        p.setnRegali(regaliPianeta);
                        if(p.getnRegali() > maxPianeta.getnRegali())
                            maxPianeta = p;
                    }
                }
            }
        }
        reader.close();
        //TASK 1
        //punto 1
        System.out.println(regaliTotali + " " + regaliOrdinati.size());
        //punto 2
        System.out.println(arte + " " + elettronica + " " + sport);
        //punto 3
        System.out.println(maxPianeta.getNomePianeta());
        //punto 4
        System.out.println(costoRegaliPianeta.getNomePianeta());
        //punto 5
    }
}
