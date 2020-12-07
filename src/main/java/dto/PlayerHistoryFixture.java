package dto;

public class PlayerHistoryFixture {
    private int team_h;
    private int team_a;
    private int team_a_score;
    private int team_h_score;
    private boolean finished;
    private int minutes;
    private int goals;
    private int assists;

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

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTotal_points() {
        return total_points;
    }

    public void setTotal_points(int total_points) {
        this.total_points = total_points;
    }

    public int getOpponent_team() {
        return opponent_team;
    }

    public void setOpponent_team(int opponent_team) {
        this.opponent_team = opponent_team;
    }

    public PlayerHistoryFixture(int team_h, int team_a, int team_a_score, int team_h_score, boolean finished, int minutes, int goals, int assists, int bonus, int total_points, int opponent_team) {
        this.team_h = team_h;
        this.team_a = team_a;
        this.team_a_score = team_a_score;
        this.team_h_score = team_h_score;
        this.finished = finished;
        this.minutes = minutes;
        this.goals = goals;
        this.assists = assists;
        this.bonus = bonus;
        this.total_points = total_points;
        this.opponent_team = opponent_team;
    }

    private int bonus;
    private int total_points;
    private int opponent_team;
}
