public class Transition {
    public String currentState;


    public String charRead ;
    public String charWrote;
    public String nextState ;
    public String direction ;
    public String decision ;


    @Override
    public String toString() {
        return "Transition{" +
                "currentState='" + currentState + '\'' +
                ", charRead='" + charRead + '\'' +
                ", charWrote='" + charWrote + '\'' +
                ", nextState='" + nextState + '\'' +
                ", direction='" + direction + '\'' +
                ", decision='" + decision + '\'' +
                '}';
    }

    // constructor
    public Transition(String currentState,String read, String wrote , String following ,String way , String decision){
        this.currentState = currentState;
        this.charRead = read;
        this.charWrote = wrote;
        this.nextState = following;
        this.direction = way ;
        this.decision = decision;

    }
}
