import java.util.ArrayList;
import java.util.List;

public class OutComeBuilder {

    String description;
    Bet bet;
    List<OutcomeOdd> outcomeOdds;

    public OutComeBuilder(String description) {
        this.description = description;
        this.outcomeOdds = new ArrayList<OutcomeOdd>();
    }
    public OutComeBuilder Bet(Bet bet){
        this.bet = bet;
        return this;
    }

    public OutComeBuilder outComeOdds(List<OutcomeOdd> outcomeOdds) {

        this.outcomeOdds = outcomeOdds;
        return this;
    }

    public Outcome build(){

        Outcome outcome = new Outcome();
        outcome.setDescription(this.description);
        outcome.setBet(this.bet);
        outcome.setOutcomeOdds(this.outcomeOdds);


        return outcome;
    }

    private OutComeBuilder() {

    }
}
