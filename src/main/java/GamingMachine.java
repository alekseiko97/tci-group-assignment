import java.util.UUID;

enum GameType {
    BlackJack, SlotMachine, Race
}

public class GamingMachine {

    private UUID machineID;
    private GameType gameType;

    public GamingMachine(GameType gameType) {
        this.machineID = UUID.randomUUID();
        this.gameType = gameType;
    }

    public UUID getMachineID() {
        return machineID;
    }

    public double placeBet(BetRound betRound, double inAmount) {
        return betRound.placeBet(new Bet(inAmount));
    }


}
