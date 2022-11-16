import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Programme {
    String fileName;
    String mot;
    private String [] alphabet;
    private  Vector<Transition> trs ;
    private ArrayList<Transition> arrayI;
    private static HashMap<String, Vector<Transition>> States = new HashMap<>();
    private enum finalAnswer {Accepted , Rejected,MachineMalfunction};

   public Programme(String fileName){
       this.fileName = fileName;
   }

    public  void lire () throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(fileName));
        arrayI = new ArrayList<>();
        boolean firstline = false;
        boolean secondline = false;
        while (br.ready()){
            if(!firstline){alphabet = br.readLine().split(" "); firstline = true;}
            if(!secondline){mot = br.readLine(); secondline = true;}
            String [] line = br.readLine().split(" ");
            arrayI.add(new Transition(line[0],line[1],line[2],line[3],line[4],line[5]));
        }

        for (Transition elm : arrayI) System.out.println(elm);
    }
    public  void reponse (){
        String [] symbols = mot.split("");
        String [] ruban = symbols;
        String current = "0";
        String answer = "";
        int i = 0;
        //for ( i = 0; i < symbols.length; i++){
        Iterator<Transition> it  = arrayI.iterator();
        System.out.println(it.hasNext());

            while(it.hasNext() && i>=0 && i<symbols.length-1){
                if(current.equals(it.next().currentState) && Objects.equals(symbols[i], it.next().charRead)){
                    if(Objects.equals(it.next().decision, "none")){
                        symbols[i]=it.next().charWrote;
                        current = it.next().nextState;
                        if(it.next().direction == "r") symbols[i]=symbols[i+1];
                        else if (i>0)symbols[i]=symbols[i-1];

                    }
                    else{
                        answer= it.next().decision ;
                        break;
                    }

                }
                else {
                    answer= it.next().decision; System.out.println("jai "+answer+" le mot "); break;
                }
            //}

        }


    }



    public static  void main(String[] args) throws IOException {


        Programme p = new Programme("/amuhome/f22022221/Documents/MachineTuring/src/src.txt");

        p.lire();
        String [] symbols = p.mot.split("");

        p.reponse();


    }
}
