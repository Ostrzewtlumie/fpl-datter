package dto;

public class PlayerRemainingFixture {

    private int team_h;
    private int team_a;
    private int team_a_score;
    private int team_h_score;
    private boolean finished;
    private int difficulty;
    private boolean is_home;

    public int getTeam_h() {
        return team_h;
    }

    public void setTeam_h(int team_h) {
        this.team_h = team_h;
    }

    public int getTeam_a() {
        return team_a;
    }

    public void setTeam_a(int team_a) {
        this.team_a = team_a;
    }

    public int getTeam_a_score() {
        return team_a_score;
    }

    public void setTeam_a_score(int team_a_score) {
        this.team_a_score = team_a_score;
    }

    public int getTeam_h_score() {
        return team_h_score;
    }

    public void setTeam_h_score(int team_h_score) {
        this.team_h_score = team_h_score;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isIs_home() {
        return is_home;
    }

    public void setIs_home(boolean is_home) {
        this.is_home = is_home;
    }

    public PlayerRemainingFixture(int team_h, int team_a, int team_a_score, int team_h_score, boolean finished, int difficulty, boolean is_home) {
        this.team_h = team_h;
        this.team_a = team_a;
        this.team_a_score = team_a_score;
        this.team_h_score = team_h_score;
        this.finished = finished;
        this.difficulty = difficulty;
        this.is_home = is_home;
    }
}
