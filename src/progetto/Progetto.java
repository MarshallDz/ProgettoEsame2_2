package progetto;

import java.util.ArrayList;
import java.util.Scanner;

public class Progetto {
    public static void main(String[] args) {
        //array dei regali totali
        ArrayList<Regalo> regali = new ArrayList<>();
        //array regali ordinati dalle citta di un pianeta
        ArrayList<String> regaliOrdinati = new ArrayList<>();
        //array dei pianeti
        ArrayList<Pianeta> pianeti = new ArrayList<>();
        ArrayList<Pianeta> pianetiVisitati = new ArrayList<>();
        //array delle citta
        ArrayList<Citta> arrCitta = new ArrayList<>();
        ArrayList<Citta> cittaVisitate = new ArrayList<>();
        //regali totali ordinati da tutti i pianeti
        int regaliTotali = 0;
        //contatori tipologia dei regali
        int regaliTipoArte = 0;
        int regaliTipoSport = 0;
        int regaliTipoElettronica = 0;
        //valore del deposito
        int deposito = 0;
        //contatori
        int contatoreTipoRegali = 0;
        int contatore1 = 0, contatore2 = Integer.MAX_VALUE;
        int p=0, q=0;
        boolean task1 = true, task2 = false, task3 = false;
        ////oggetti per trovare il max
        Pianeta maxPianeta = new Pianeta("" , 0);
        Pianeta maxCostoRegaliPianeta = new Pianeta(" ", 0);
        Citta cittaPiuRegali = new Citta(" ", " ",  0);
        Citta cittadinaPiuCase = new Citta(" ", " ", 0);
        Citta cittaPiuCollegamenti = new Citta(" ", " ", 0);
        Citta cittaPiuCosto = new Citta(" ", " ", 0);
        Collegamento arco;
        ArrayList<String> destinazioni = new ArrayList<>();
        ArrayList<Integer> pesi = new ArrayList<>();
        //lettura file
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            contatore1++;
            String line = scanner.nextLine();
            String[] splittedArr = line.split(" |\\#|\\,");
            if (splittedArr[0].charAt(0) == 'r') {
                Regalo regalo = new Regalo(splittedArr[0], Integer.parseInt(splittedArr[1]), splittedArr[2]);
                regali.add(regalo);
            } else if (splittedArr[0].charAt(0) == 'p') {
                Pianeta pianeta = new Pianeta(splittedArr[0], Integer.parseInt(splittedArr[1]));
                pianeti.add(pianeta);
            } else if (splittedArr[0].charAt(0) == 'c') {
                if (splittedArr.length > 1 && splittedArr[1].charAt(0) == 'p') {
                    arrCitta.add(new Citta(splittedArr[0], splittedArr[1], Integer.parseInt(splittedArr[2])));
                    for (int j = 3; j < splittedArr.length; j++) {
                        if (j % 2 == 1) {
                            destinazioni.add(splittedArr[j]);
                            if (splittedArr[j].charAt(0) != 'c') {
                                pesi.add(0);
                            }
                        } else pesi.add(Integer.parseInt(splittedArr[j]));
                    }
                    for(Citta citta : arrCitta) {
                        if (citta.getNomeCitta().equals(splittedArr[0]))
                            for (int i = 0; i < pesi.size(); i++) {
                                arco = new Collegamento(destinazioni.get(i), pesi.get(i));
                                citta.aggiungiArco(arco);
                            }
                    }
                    destinazioni.clear();
                    pesi.clear();
                }
                else if (splittedArr.length > 1 && splittedArr[1].charAt(0) == ':'){
                    for(Citta citta: arrCitta) {
                        if(splittedArr[0].equalsIgnoreCase(citta.getNomeCitta())) {
                            for (int i = 2; i < splittedArr.length; i++) {
                                for (Regalo r : regali) {
                                    if (splittedArr[i].equalsIgnoreCase(r.getNomeRegalo())) {
                                        citta.aggiungiRegalo(r);
                                    }
                                }
                            }
                            regaliTotali += citta.regaliSize();
                        }
                    }
                    for (Pianeta planet : pianeti) {
                        //controllo se la citta e' nell'array delle citta
                        for (Citta citta : arrCitta) {
                            if (citta.getNomeCitta().equals(splittedArr[0])) {
                                if (citta.getPianetaO().equals(planet.getNomePianeta())) {
                                    for (int i = 2; i < splittedArr.length; i++) {
                                        for (Regalo r : regali) {
                                            if (r.getNomeRegalo().equals(splittedArr[i])) {
                                                planet.incrementaCosto(r.getCosto());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (planet.getCostoRegali() > maxCostoRegaliPianeta.getCostoRegali()) maxCostoRegaliPianeta = planet;
                    }

                    for (int i = 2; i < splittedArr.length; i++) {
                        if (!regaliOrdinati.contains(splittedArr[i])) {
                            regaliOrdinati.add(splittedArr[i]);
                        }
                        for (Regalo r : regali) {
                            if (r.getNomeRegalo().equals(splittedArr[i])) {
                                switch (r.getTipo()) {
                                    case "arte" -> regaliTipoArte++;
                                    case "elettronica" -> regaliTipoElettronica++;
                                    case "sport" -> regaliTipoSport++;
                                }
                            }
                        }
                    }
                    for (Pianeta planet : pianeti) {
                        for (Citta citta : arrCitta) {
                            if (citta.getPianetaO().equals(planet.getNomePianeta())) {
                                planet.incrementaNregali(splittedArr.length - 2);
                            }
                        }
                        if (planet.getnRegali() > maxPianeta.getnRegali())
                            maxPianeta = planet;
                    }

                    for (Citta citta : arrCitta) {
                        if (splittedArr[0].equals(citta.getNomeCitta())) {
                            citta.incrementaRegaliRichiesti(splittedArr.length - 2);

                        }
                        if (citta.getnCase() > 10) {
                            if (citta.getnCase() > cittadinaPiuCase.getnCase()) {
                                cittadinaPiuCase = citta;
                            }
                        }
                        if (citta.getRegaliRichiesti() > cittaPiuRegali.getRegaliRichiesti()) cittaPiuRegali = citta;
                        if (citta.getNumeroArchi() > cittaPiuCollegamenti.getNumeroArchi()) cittaPiuCollegamenti = citta;
                    }
                }

            }else if(splittedArr[0].equalsIgnoreCase(("task2"))){
                task1 = false;
                task2 = true;
                p = Integer.parseInt(splittedArr[1]);
                q = Integer.parseInt(splittedArr[2]);

            } else if (splittedArr[0].equalsIgnoreCase(("task3"))) {
                task1 = false;
                task3 = true;
                contatore2 = contatore1;
            }
            else deposito = Integer.parseInt(splittedArr[0]);
            if (contatore1 > contatore2) {
                for (Pianeta planet : pianeti) {
                    for (Citta citta : arrCitta) {
                        if (splittedArr[0].equals(citta.getNomeCitta())) {
                            if (citta.getPianetaO().equals(planet.getNomePianeta())) {
                                if (!cittaVisitate.contains(citta))
                                    cittaVisitate.add(citta);
                                if (!pianetiVisitati.contains(planet))
                                    pianetiVisitati.add(planet);
                                deposito -= citta.getRegaliRichiesti();
                            }
                        }
                    }
                }
            }
        }
        scanner.close();
        if(task1) {
            //punto 1
            System.out.println(regaliTotali + " " + regaliOrdinati.size());
            //punto 2
            System.out.println(regaliTipoArte + " " + regaliTipoElettronica + " " + regaliTipoSport);
            //punto 3
            System.out.println(maxPianeta.getNomePianeta());
            //punto 4
            System.out.println(maxCostoRegaliPianeta.getNomePianeta());
            //punto 5
            System.out.println(cittaPiuRegali.getNomeCitta());
            //punto 6
            System.out.println(cittadinaPiuCase.getNomeCitta());
            //punto 7
            System.out.println(cittaPiuCollegamenti.getNomeCitta());
        }
        else if(task2){
            boolean valid = true;
            for(Pianeta planet: pianeti){
                //punto 1
                for (Citta citta: arrCitta) {
                    if(citta.getRegaliRichiesti() < p || citta.getRegaliRichiesti() > q){
                        valid = false;
                        break;
                    }
                }
                //punto 2
                for (Citta citta: arrCitta){
                    if (citta.getPianetaO().equals(planet.getNomePianeta())) {
                        if(citta.getPesoArchi() > cittaPiuCosto.getPesoArchi()) cittaPiuCosto = citta;
                        else if(citta.getPesoArchi() == cittaPiuCosto.getPesoArchi()){
                            valid = false;
                            break;
                        }
                    }
                }
                //punto 3
                for(int i = 0; i < arrCitta.size(); i++) {
                    if (arrCitta.get(i).getPianetaO().equals(planet.getNomePianeta())) {
                        if (arrCitta.get(i).getNumeroArchi() > 1) {
                            for (Collegamento archi : arrCitta.get(i).getArchi()) {
                                for (Citta citta : arrCitta) {
                                    if (archi.getDestinazione().equals(citta.getNomeCitta())) {
                                        if (arrCitta.get(i).getArte() == citta.getArte() && arrCitta.get(i).getElettronica() == citta.getElettronica()) {
                                            contatoreTipoRegali++;
                                            if (contatoreTipoRegali == 3) {
                                                valid = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //punto 4
                if(planet.getnCitta() > 1) {
                    for (int i = 0; i < arrCitta.size(); i++) {
                        for(int j = i + 1; j < arrCitta.size(); j++){
                            if (arrCitta.get(i).getPianetaO().equals(planet.getNomePianeta()) && arrCitta.get(j).getPianetaO().equals(planet.getNomePianeta())){
                                if(!(arrCitta.get(i).getSport() >= 1 && arrCitta.get(j).getSport() >= 1) &&
                                   !(arrCitta.get(i).getArte() >= 1 && arrCitta.get(j).getArte() >= 1)   &&
                                   !(arrCitta.get(i).getElettronica() >= 1 && arrCitta.get(j).getElettronica() >= 1)){
                                    valid = false;
                                }
                            }
                        }
                    }
                }
            }
            if(valid) System.out.println("YES");
            else System.out.println("NO");
        }
        else if (task3) {
            if(deposito >= 0 && (pianetiVisitati.size() == pianeti.size()) && (cittaVisitate.size() == arrCitta.size()))
                System.out.println("VALID");
            else System.out.println("NOT VALID");
        }
    }
}